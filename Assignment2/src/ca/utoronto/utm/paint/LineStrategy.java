package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;


/**
 * This class creates a strategy for manipulating an instance of Line,
 * drawn on the paint panel.
 * 
 * @author Roman Huts, Shahmir Durrani
 *
 */
public class LineStrategy implements ShapeManipulatorStrategy {
	private PaintPanel panel;
	private Boolean isDrawing = false;
	
	
	/**
	 * This method constructs an instance of a Line Strategy, that can be used by paint panel to manipulate the shape.
	 * 
	 * @param paintpanel the paint panel that the line is drawn on.
	 */
	public LineStrategy(PaintPanel paintpanel){
		this.panel = paintpanel;
	}

	/**
	 * This method runs the strategy that allows the feedback to be shown when dragging the mouse to determine the
	 * length and direction of the line.
	 * 
	 * @param a MouseEvent used for extracting the position of the mouse on the screen.
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		if(isDrawing) {
			panel.setShape(panel.getModel().getShapes().getLast());
			panel.getShape().setEnd(new Point(e.getX(), e.getY()));
			panel.repaint();
		}
	}

	/**
	 * This method runs the strategy that allows the initial point of the line to be selected.
	 *
	 * @param a MouseEvent used for extracting the position of the mouse on the screen.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		Point p = new Point(e.getX(), e.getY());
		panel.setShape(panel.getFactory().getShape(panel.getMode()));
		panel.getShape().setStart(p);
		panel.getShape().setColor(panel.getColor());
		panel.getShape().setStrokeSize(panel.getStrokeSize());
		panel.getModel().addShape(panel.getShape());
		isDrawing = true;
	}

	/**
	 * This method runs the strategy that sets the line to be the final position that the mouse is at when the mouse is released
	 *
	 * @param a MouseEvent used for extracting the position of the mouse on the screen.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		if(isDrawing) {
			panel.setShape(panel.getModel().getShapes().getLast());
			panel.getShape().setEnd(new Point(e.getX(), e.getY()));
			panel.repaint();
			isDrawing = false;
		}
	}

	//UnUsed Methods
	@Override
	public void mouseMoved(MouseEvent e) {	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
		

}
