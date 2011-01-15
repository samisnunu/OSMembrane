package de.osmembrane.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import de.osmembrane.controller.exceptions.ExceptionSeverity;
import de.osmembrane.view.IView;
import de.osmembrane.view.dialogs.ErrorDialog;
import de.osmembrane.view.frames.MainFrame;

/**
 * The view registry implements the View-Handler pattern to organize the
 * {@link IView}s.
 * 
 * @author tobias_kuhn
 * 
 */
public class ViewRegistry extends Observable implements Observer {

	/**
	 * implements the error-handling dialog Note: This is important to be static
	 * and external to the ViewRegistry instance, because anyway else occurring
	 * exceptions during anything static would cause an
	 * ExceptionInInitializerError because the error handling would require the
	 * ViewRegistry instance to be available.
	 */
	private static ErrorDialog errorDialog;

	/**
	 * implements the Singleton pattern
	 */
	private static ViewRegistry instance = new ViewRegistry();

	/**
	 * internal storage of the views, indexed by class
	 */
	private Map<Class<? extends IView>, IView> views = new HashMap<Class<? extends IView>, IView>();

	/**
	 * initializes the view registry
	 */
	private ViewRegistry() {
		// try to set LnF to Nimbus, if available
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// if setLookAndFeel() failed
			ViewRegistry.showException(this.getClass(),
					ExceptionSeverity.UNEXPECTED_BEHAVIOR, e);
		}

	}

	/**
	 * 
	 * @return the one and only instance of ViewRegistry
	 */
	public static ViewRegistry getInstance() {
		return instance;
	}

	/**
	 * Adds a view to the registry
	 * 
	 * @param view
	 *            IView to add
	 */
	public void register(IView view) {
		views.put(view.getClass(), view);
	}

	/**
	 * Returns a view from the registry. If not already registered, creates it
	 * and registers it.
	 * 
	 * @param clazz
	 *            desired class to return
	 * @return the registered object for that class
	 */
	public IView get(Class<? extends IView> clazz) {
		IView result = views.get(clazz);

		// if it does not exist, create it
		if (result == null) {
			try {
				result = clazz.newInstance();
			} catch (Exception e) {
				showException(this.getClass(),
						ExceptionSeverity.UNEXPECTED_BEHAVIOR, e);
			}
			views.put(clazz, result);
		}

		return result;
	}

	@Override
	public void update(Observable o, Object arg) {
		// forward update() for Model classes
		setChanged();
		notifyObservers(arg);
	}

	/**
	 * Note: The view registry can be exchanged along with all view components,
	 * so it has to identify its main window for the purpose of showing this
	 * window at startup.
	 * 
	 * @return the main frame of this view component
	 */
	public IView getMainFrame() {
		return get(MainFrame.class);
	}

	/**
	 * Displays an occurred exception using the ExceptionDialog. This method
	 * should not be called directly. Use the Controller's handleException()
	 * method instead.
	 * 
	 * @param t
	 *            class in which the Exception occurred
	 * @param severity
	 *            indicates what happened and how fatal it is
	 * @param causingObject
	 *            object that caused the
	 */
	public static void showException(Throwable t, ExceptionSeverity severity,
			Object causingObject) {
		if (errorDialog == null) {
			errorDialog = new ErrorDialog();
		}
		errorDialog.showException(t, severity, causingObject);
	}
}