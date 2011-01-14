package de.osmembrane.controller;

import java.util.HashMap;
import java.util.Map;

import javax.swing.Action;

import de.osmembrane.controller.actions.AddConnectionAction;
import de.osmembrane.controller.actions.AddFunctionAction;
import de.osmembrane.controller.actions.ChangeSettingsAction;
import de.osmembrane.controller.actions.DeleteConnectionAction;
import de.osmembrane.controller.actions.DeleteFunctionAction;
import de.osmembrane.controller.actions.DuplicateFunctionAction;
import de.osmembrane.controller.actions.EditBoundingBoxPropertyAction;
import de.osmembrane.controller.actions.EditFilePropertyAction;
import de.osmembrane.controller.actions.EditListPropertyAction;
import de.osmembrane.controller.actions.EditPropertyAction;
import de.osmembrane.controller.actions.ExecutePipelineAction;
import de.osmembrane.controller.actions.ExitAction;
import de.osmembrane.controller.actions.ExportPipelineAction;
import de.osmembrane.controller.actions.GeneratePipelineAction;
import de.osmembrane.controller.actions.ImportPipelineAction;
import de.osmembrane.controller.actions.LoadPipelineAction;
import de.osmembrane.controller.actions.MoveFunctionAction;
import de.osmembrane.controller.actions.NewPipelineAction;
import de.osmembrane.controller.actions.PreviewPipelineAction;
import de.osmembrane.controller.actions.RedoAction;
import de.osmembrane.controller.actions.SavePipelineAction;
import de.osmembrane.controller.actions.ShowHelpAction;
import de.osmembrane.controller.actions.UndoAction;

/**
 * The action registry implements the Broker pattern to organize the
 * {@link Action}s.
 * 
 * @author tobias_kuhn
 * 
 */
public class ActionRegistry {
	/**
	 * implements the Singleton pattern
	 */
	private static ActionRegistry instance = new ActionRegistry();

	/**
	 * internal storage of the actions, indexed by class
	 */
	public Map<Class<? extends Action>, Action> actions = new HashMap<Class<? extends Action>, Action>();

	/**
	 * initializes the action registry with all the actions this controller
	 * component has
	 */
	private ActionRegistry() {
		// pipeline actions
		register(new NewPipelineAction());
		register(new SavePipelineAction());
		register(new LoadPipelineAction());
		register(new ExportPipelineAction());
		register(new ImportPipelineAction());
		register(new GeneratePipelineAction());
		register(new ExecutePipelineAction());
		register(new PreviewPipelineAction());

		// function actions
		register(new AddFunctionAction());
		register(new MoveFunctionAction());
		register(new DuplicateFunctionAction());
		register(new DeleteFunctionAction());

		// connection actions
		register(new AddConnectionAction());
		register(new DeleteConnectionAction());

		// property actions
		register(new EditPropertyAction());
		register(new EditListPropertyAction());
		register(new EditFilePropertyAction());
		register(new EditBoundingBoxPropertyAction());

		// undo, redo actions
		register(new UndoAction());
		register(new RedoAction());

		// other actions
		register(new ShowHelpAction());
		register(new ChangeSettingsAction());
		register(new ExitAction());
	}

	/**
	 * 
	 * @return the one and only instance of ActionRegistry
	 */
	public static ActionRegistry getInstance() {
		return instance;
	}

	/**
	 * Adds an action to the registry
	 * 
	 * @param action
	 *            Action to add
	 */
	public void register(Action action) {
		actions.put(action.getClass(), action);
	}

	/**
	 * Returns an action from the registry
	 * 
	 * @param clazz
	 *            desired class to return
	 * @return the registered object for that class
	 */
	public Action get(Class<? extends Action> clazz) {
		return actions.get(clazz);
	}
}