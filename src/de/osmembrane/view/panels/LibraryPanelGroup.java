package de.osmembrane.view.panels;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import de.osmembrane.model.AbstractFunction;
import de.osmembrane.model.AbstractFunctionGroup;
import de.osmembrane.view.ViewRegistry;

/**
 * A group panel that is placed for each FunctionGroup on the LibraryPanel
 * 
 * @author tobias_kuhn
 * 
 */
public class LibraryPanelGroup extends JPanel {

	private static final long serialVersionUID = -2502154263887966328L;

	/**
	 * The id this panel group has in its main Library panel (used for click
	 * handling calls)
	 */
	private int id;

	/**
	 * The header button of this panel group that can make it expandable or
	 * contractable
	 */
	private JButton headerButton;

	/**
	 * The height of the contained objects
	 */
	private int contentHeight;

	/**
	 * The contained objects
	 */
	private List<JLabel> content;

	/**
	 * Initializes a new LibraryPanelGroup
	 * 
	 * @param lp
	 *            the parent LibraryPanel on which this group will be displayed
	 * @param afg
	 *            the {@link AbstractFunctionGroup} which this LibraryPanelGroup
	 *            represents
	 */
	public LibraryPanelGroup(final LibraryPanel lp, AbstractFunctionGroup afg) {
		// display
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		// best decision ever <- do not touch
		setLayout(null);

		int y = 3;
		// find the preferred width by using the maximum of all child objects
		int maxPreferredWidth = 0;

		// header button
		headerButton = new JButton();
		headerButton.setText(afg.getFriendlyName());

		headerButton.setLocation(3, y);
		headerButton.setSize(headerButton.getPreferredSize());
		maxPreferredWidth = headerButton.getPreferredSize().width;
		y += headerButton.getHeight() + 6;

		headerButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				lp.groupClicked(id);
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		add(headerButton);

		content = new ArrayList<JLabel>();
		// all functions available in the function group
		for (AbstractFunction af : afg.getFunctions()) {
			JLabel jl = new JLabel(af.getFriendlyName());

			jl.setLocation(3, y);
			jl.setSize(jl.getPreferredSize());
			maxPreferredWidth = Math.max(maxPreferredWidth,
					jl.getPreferredSize().width);
			y += jl.getHeight() + 6;

			contentHeight += jl.getPreferredSize().height;

			content.add(jl);
		}

		setPreferredSize(new Dimension(maxPreferredWidth, 0));
	}

	/**
	 * @param id
	 *            the id this panel group has in its main Library panel to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return the height of this group's contents, if they are expanded
	 */
	public int getContentHeight() {
		return contentHeight;
	}

	@Override
	public Dimension getPreferredSize() {
		Dimension result = super.getPreferredSize();
		result.height = headerButton.getPreferredSize().height;
		return result;
	}

	/**
	 * Sets the height for this group's contents
	 * 
	 * @param newHeight
	 *            0, if contracted, getFullHeight() if expanded
	 */
	public void setContentHeight(int newHeight) {
		setSize(getWidth(), headerButton.getPreferredSize().height + 6
				+ newHeight);
	}

	/**
	 * Gets called when the library panel has rearranged the library panel group
	 */
	public void rearranged() {
		headerButton.setSize(getWidth() - 6,
				headerButton.getPreferredSize().height);
		for (JLabel jl : content) {
			jl.setSize(this.getWidth() - 6, jl.getPreferredSize().height);
		}
	}

}