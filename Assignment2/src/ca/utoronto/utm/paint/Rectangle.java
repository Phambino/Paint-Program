package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import javax.xml.ws.Endpoint;

/**
 * This class represents a rectangle shape represented by a corner point and a
 * width and height to be drawn on the paint panel.
 * 
 * @author Dean Wedgbury
 *
 */
public class Rectangle implements Shape {

	private Point corner; // the starting corner point of a rectangle
	private int width; // the horizontal width of a rectangle
	private int length; // the vertical length of a rectangle
	private Color color;
	private int strokeSize;
	private Point endPoint;
	private Boolean isFilled = false;
	
	public Rectangle(){
		this.width = 0;
		this.length = 0;
	}

	/**
	 * Initializes a rectangle from a specified corner, width and length
	 * 
	 * @param corner
	 * 				a Point to indicate the initial corner of a rectangle
	 * @param width
	 * 				an integer value for the width of the rectangle
	 * @param length
	 * 				an integer value for the length of the rectangle
	 */
	public Rectangle(Point corner, int width, int length) {
		this.corner = corner;
		this.width = width;
		this.length = length;
	}

	/**
	 * gets the width of a rectangle
	 * 
	 * @return
	 * 			an integer of the rectangle's width
	 */
	public int getWidth() {
		return width;
	}
	
	
	/**
	 * gets the length of a rectangle
	 * 
	 * @return
	 * 			an integer of the rectangle's length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * gets the corner of a rectangle
	 * 
	 * @return
	 * 			a Point of the rectangle's initial corner
	 */
	public Point getCorner() {
		return corner;
	}

	/**
	 * sets the rectangle's length
	 * 
	 * @param length
	 * 				an integer value of the rectangle's length
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * sets the rectangle's width
	 * 
	 * @param width
	 * 				an integer value of the rectangle's width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * sets the rectangle's corner point
	 * 
	 * @param corner
	 * 				a Point for the rectangle's corner
	 */	
	public void setCorner(Point corner) {
		this.corner = corner;
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
		int endX, endY, startX, startY, x, y;
		endX = endPoint.getX();
		endY = endPoint.getY();
		startX = corner.getX();
		startY = corner.getY();
		x = startX;
		y = startY;
		if (endX < startX) {
		   x = endX;
		}
		if (endY < startY) {
		   y = endY;
		}

		int width = Math.abs(startX - endX);
		int height = Math.abs(startY - endY);
		g2d.setColor(this.color);
		g2d.setStroke(new BasicStroke(this.strokeSize));
		if(this.getisFilled() == false){
			g2d.drawRect(x, y, width, height);
		}else{
			g2d.fillRect(x,y,width,height);
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

	@Override
	public void setStart(Point p) {
		// TODO Auto-generated method stub
		this.corner =p;
	}

	@Override
	public void setEnd(Point p) {
		// TODO Auto-generated method stub
		endPoint = p;
		
	}

}
