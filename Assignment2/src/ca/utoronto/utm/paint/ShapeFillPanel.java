package ca.utoronto.utm.paint;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 * Provides access to changing the selected color with which
 * subsequent GraphicalObjects will be drawn with. Displays current
 * selected color.
 * 
 * @author Roman Huts
 *
 */
public class ShapeFillPanel extends JPanel {
	private PaintPanel paintPanel; // so we can tell paintPanel to update its
									// selected color
	private JCheckBox isFilledCheckBox;

	/**
	 * Displays a CheckBox for deciding whether or not to fill the shape being drawn
	 * 
	 * @param paintPanel
	 *            the panel that the color selection changes will affect
	 */
	public ShapeFillPanel(PaintPanel paintPanel) {
		this.paintPanel = paintPanel;
		this.isFilledCheckBox = new JCheckBox("Fill Shape");

		this.add(isFilledCheckBox);
		isFilledCheckBox.addItemListener(new ItemListener() {

			@Override
	        public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED){
					paintPanel.setisFilled(true);
					System.out.println("IS SELECTED");
	            }
				if (e.getStateChange() == ItemEvent.DESELECTED){
					paintPanel.setisFilled(false);
					System.out.println("IS DESELECTED");
	            }
			}
	    });
	}

}
