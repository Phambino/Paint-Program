package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Polyline implements Shape {
	
	private Point start; // The beginning point of a line
	private Point end; // The ending point of a line
	private Color color;
	private int strokeSize;
	private Boolean isFilled;
	private ArrayList<Point> points = new ArrayList<>();
	
	public Polyline(){
	}

	/**
	 * Constructs a line from a specified start point and end point
	 * 
	 * @param start
	 *            a Point for the starting point of a line
	 * @param end
	 *            a Point for the ending point of a line
	 */
	public Polyline(Point start, Point end) {
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
	 * Gets the array list of points
	 * 
	 * @return Array List containing points.
	 */
	public ArrayList<Point> getPoints() {
		return this.points;
	}


	/**
	 * Sets the starting point of the line
	 * 
	 * @param start
	 *            a Point to be the starting point
	 */
	public void setStart(Point start) {
		points.add(start);
	}

	/**
	 * Sets the ending point of the line
	 * 
	 * @param end
	 *            a Point to be the ending point
	 */
	public void setEnd(Point end) {
		points.add(end);
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
		
		for (int i = 0; i < points.size() - 1; i++) {
			int p1x = points.get(i).getX();
			int p1y= points.get(i).getY();
			int p2x= points.get(i + 1).getX();
			int p2y= points.get(i + 1).getY();
			g2d.setColor(this.color);
			g2d.setStroke(new BasicStroke(this.strokeSize));
			g2d.drawLine(p1x, p1y, p2x, p2y);
		}	
	
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
