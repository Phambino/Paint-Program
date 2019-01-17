package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;


/**
 * This class creates a strategy for manipulating an instance of Rectangle,
 * drawn on the paint panel.
 * 
 * @author Roman Huts, Shahmir Durrani
 *
 */
public class RectangleStrategy implements ShapeManipulatorStrategy {
	private PaintPanel panel;
	
	/**
	 * This method constructs an instance of the Rectangle Strategy, that can be used by paint panel to manipulate the shape.
	 * 
	 * @param paintpanel the paint panel that the Rectangle is drawn on.
	 */
	public RectangleStrategy(PaintPanel paintpanel){
		this.panel = paintpanel;
	}

	/**
	 * This method runs the strategy that allows the feedback to be shown when dragging the mouse to determine the
	 * length and width of the rectangle
	 * 
	 * @param a MouseEvent used for extracting the position of the mouse on the screen.
	 */	
	@Override
	public void mouseDragged(MouseEvent e) {
		panel.setShape(panel.getModel().getShapes().getLast());
		panel.getShape().setEnd(new Point(e.getX(), e.getY()));
		panel.repaint();
	}

	/**
	 * This method runs the strategy that allows the initial corner of the rectangle to be selected
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
		panel.getShape().setisFilled(panel.getisFilled());
		panel.getModel().addShape(panel.getShape());

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
	@Override
	public void mouseReleased(MouseEvent e) {
	}
			

}
