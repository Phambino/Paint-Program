package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Provides access to changing the selected color with which
 * subsequent GraphicalObjects will be drawn with. Displays current
 * selected color.
 * 
 * @author Roman Huts
 *
 */
public class ColorChooserPanel extends JPanel {
	private PaintPanel paintPanel; // so we can tell paintPanel to update its
									// selected color
	private JButton chooseButton;
	private JTextField currColorLabel;

	/**
	 * Displays a button for accessing the JColorChooser component to set the
	 * current color as well as displays the currently selected color.
	 * 
	 * @param paintPanel
	 *            the panel that the color selection changes will affect
	 */
	public ColorChooserPanel(PaintPanel paintPanel) {
		this.paintPanel = paintPanel;
		this.chooseButton = new JButton("Choose Color");
		this.currColorLabel = new JTextField(2);

		this.add(chooseButton);
		this.add(currColorLabel);
		currColorLabel.setEditable(false);
		currColorLabel.setOpaque(true);
		// current color indicator updated (to default)
		currColorLabel.setBackground(this.paintPanel.getColor());

		chooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Color color = JColorChooser.showDialog(null, "Pick Your Color!", Color.WHITE);
				if (color == null) {
					color = Color.WHITE;
				}
				paintPanel.setColor(color);
				// current color indicator updated (to selected color)
				currColorLabel.setBackground(paintPanel.getColor());

			}
		});

	}

}
