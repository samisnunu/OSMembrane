package de.osmembrane.view;

import javax.swing.JFrame;

/**
 * An abstract class interface to be used for dialog frame elements.
 * 
 * @author tobias_kuhn
 *
 */
@SuppressWarnings("serial")
public abstract class AbstractFrame extends JFrame implements IView {
	
	/**
	 * common constructor for all dialog frame elements
	 */
	public AbstractFrame() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	@Override
	public void showWindow() {
		setVisible(true);
	}

	@Override
	public void hideWindow() {
		setVisible(false);
	}

	@Override
	public void setWindowTitle(String title) {
		setTitle(title);
	}

}