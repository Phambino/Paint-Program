package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * This class creates lines represented by a starting and ending point to be
 * drawn on the paint panel.
 * 
 * @author Dean Wedgbury
 *
 */
public class Line implements Shape {
	private Point start; // The beginning point of a line
	private Point end; // The ending point of a line
	private Color color;
	private int strokeSize;
	private Boolean isFilled = false;
	
	public Line(){
	}

	/**
	 * Constructs a line from a specified start point and end point
	 * 
	 * @param start
	 *            a Point for the starting point of a line
	 * @param end
	 *            a Point for the ending point of a line
	 */
	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}

	/**
	 * Gets the starting point of the line
	 * 
	 * @return Point the starting point
	 */
	public Point getStart() {
		return this.start;
	}

	/**
	 * Gets the ending point of the line
	 * 
	 * @return Point the ending point
	 */
	public Point getEnd() {
		return this.end;
	}

	/**
	 * Sets the starting point of the line
	 * 
	 * @param start
	 *            a Point to be the starting point
	 */
	public void setStart(Point start) {
		this.start = start;
	}

	/**
	 * Sets the ending point of the line
	 * 
	 * @param end
	 *            a Point to be the ending point
	 */
	public void setEnd(Point end) {
		this.end = end;
	}

	@Override
	public Boolean getisFilled() {
		return this.isFilled;
	}

	@Override
	public void setisFilled(Boolean isFilled) {
		this.isFilled = isFilled;	
	}
	@Override
	public void execute(Graphics2D g2d) {
		// TODO Auto-generated method stub
		int p1x= this.start.getX();
		int p1y= this.start.getY();
		int p2x= this.end.getX();
		int p2y= this.end.getY();
		g2d.setColor(this.color);
		g2d.setStroke(new BasicStroke(this.strokeSize));
		g2d.drawLine(p1x, p1y, p2x, p2y);
		
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}

	@Override
	public void setColor(Color c) {
		// TODO Auto-generated method stub
		this.color = c;
		
	}

	@Override
	public int getStrokeSize() {
		// TODO Auto-generated method stub
		return this.strokeSize;
	}

	@Override
	public void setStrokeSize(int size) {
		// TODO Auto-generated method stub
		this.strokeSize = size;
		
	}
}
