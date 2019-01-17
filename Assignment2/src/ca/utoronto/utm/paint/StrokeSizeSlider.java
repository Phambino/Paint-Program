package ca.utoronto.utm.paint;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class creates a Java Swing slider to adjust the stroke width of shapes
 * in the paint panel.
 * 
 * @author Dean Wedgbury
 *
 */
public class StrokeSizeSlider extends JPanel implements ChangeListener {

	private View view; // the paint program's view
	private PaintPanel paintPanel; // the paint program's paint panel
	private JSlider strokeSize; // a slider component to be added to the view

	/**
	 * Initializes a slider with stroke width values associated to the slider
	 * ticks, and adds it to the view.
	 * 
	 * @param view
	 *            the paint program's view
	 * @param paintPanel
	 *            the paint program's paint panel
	 */
	public StrokeSizeSlider(View view, PaintPanel paintPanel) {
		strokeSize = new JSlider(JSlider.HORIZONTAL, 1, 16, 1);
		JLabel sizeLabel = new JLabel("Stroke Size:");
		strokeSize.addChangeListener(this);

		this.view = view;
		this.paintPanel = paintPanel;

		strokeSize.setMajorTickSpacing(5);
		strokeSize.setMinorTickSpacing(1);
		strokeSize.setPaintTicks(true);
		strokeSize.setPaintLabels(true);
		this.add(sizeLabel);
		this.add(strokeSize);

	}

	/**
	 * If the slider is adjusted, the paint panel is notified of the selected
	 * value, and sets the panel's stroke size.
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {
			this.paintPanel.setStrokeSize((int) source.getValue());

		}
	}
}