package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;


/**
 * This class creates a strategy for manipulating an instance of Squiggle,
 * drawn on the paint panel.
 * 
 * @author Roman Huts, Shahmir Durrani
 *
 */
public class SquiggleStrategy implements ShapeManipulatorStrategy {
	private PaintPanel panel;
	private int counter= 0;
	
	/**
	 * This method constructs an instance of the Squiggle Strategy, that can be used by paint panel to manipulate the shape.
	 * @param paintpanel the paint panel that the Squiggle is drawn on.
	 */
	public SquiggleStrategy(PaintPanel paintpanel){
		this.panel = paintpanel;
	}

	/**
	 * This method runs the strategy that allows the feedback to be shown when dragging the mouse to determine the
	 * path of the squiggle
	 * 
	 * @param a MouseEvent used for extracting the position of the mouse on the screen.
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		Point p = new Point(e.getX(), e.getY());
		panel.setShape(panel.getModel().getShapes().getLast());
		panel.getShape().setEnd(p);
		panel.repaint();
	}

	/**
	 * This method runs the strategy that allows the initial point of the Squiggle to be selected.
	 *
	 * @param a MouseEvent used for extracting the position of the mouse on the screen.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if (counter == 0){
			Point p = new Point(e.getX(), e.getY());
			panel.setShape(panel.getFactory().getShape(panel.getMode()));
			panel.getShape().setStart(p);
			panel.getShape().setColor(panel.getColor());
			panel.getShape().setStrokeSize(panel.getStrokeSize());
			panel.getModel().addShape(panel.getShape());
			counter++;
		}
	}

	/**
	 * This strategy is used for reseting the counter, 
	 * when the mouse exits the screen, so that a new polyline can be created.
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		counter = 0;
	}

	//UnUsed Methods
	@Override
	public void mouseMoved(MouseEvent e) {	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
		
}
