package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**
 * This class creates a strategy for manipulating an instance of Polyline
 * drawn on the paint panel.
 * 
 * @author Roman Huts, Shahmir Durrani
 *
 */
public class PolylineStrategy implements ShapeManipulatorStrategy {
	private PaintPanel panel;
	private int counter = 0;
	
	/**
	 * This method constructs an instance of the Poly Line Strategy, that can be used by paint panel to manipulate the shape.
	 * @param paintpanel the paint panel that the polyline is drawn on.
	 */
	public PolylineStrategy(PaintPanel paintpanel){
		this.panel = paintpanel;
	}
	
	/**
	 * This method runs the strategy for designating the first point in the polyline.
	 * @param paintpanel the paint panel that the line is drawn on.
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
	 * This method runs the strategy for assigning consecutive points to the polyline and respectively
	 * connecting the points.
	 * 
	 * @param paintpanel the paint panel that the line is drawn on.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		Point p = new Point(e.getX(), e.getY());
		panel.setShape(panel.getModel().getShapes().getLast());
		panel.getShape().setEnd(p);
		panel.repaint();
	}
	
	/**
	 * This strategy is used for reseting the counter, 
	 * when the mouse exits the screen, so that a new polyline can be created.
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		counter = 0;
	}

	
	// Unused Methods
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseMoved(MouseEvent e) {
	}
	@Override
	public void mouseDragged(MouseEvent e) {
	}

}
