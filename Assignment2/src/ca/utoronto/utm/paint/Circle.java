package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * A Circle class that extends Graphic Objects.
 * Creates a circle shape with a location on the screen represented by centre,
 * and an integer representing the radius.
 */
public class Circle implements Shape {
	private Point centre; //A Point indicating the location of centre on the screen.
	private int radius; // An integer indicating the distance from the centre of the circle to the edge.
	private Color color;
	private int strokeSize;
	private Point endPoint;
	private Boolean isFilled = false;
	
	public Circle(){
		radius = 0;
		
	}
	
	/**
	 * This method constructs an instance of the circle with the provided centre location and radius.
	 * @param centre a Point indicating the location of the centre of the circle
	 * @param radius an integer indicating the radius
	 */
	public Circle(Point centre, int radius){
		this.centre = centre;
		this.radius = radius;
	}

	/**
	 * A method that returns the location of the centre of the circle.
	 * @return the Point indicating the centre of the cirlce
	 */
	public Point getCentre() {
		return centre;
	}

	/**
	 * Takes in a new Point and sets it as the new centre of the circle
	 * @param centre A Point indicating a location on the screen
	 */
	public void setCentre(Point centre) {
		this.centre = centre;
	}
	
	/**
	 * Method returns the radius of the circle.
	 * @return An integer indicating the radius of the circle
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * Method takes in a new radius value and assigns it to the circle.
	 * @param radius  An integer indicating a new radius.
	 */
	public void setRadius(int radius) {
		this.radius = radius;
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
		int x = centre.getX();
		int y = centre.getY();
		if (endPoint == null) {
			this.radius = 0;
		} else {
			this.radius = (int) Math.sqrt((Math.pow(Math.abs(endPoint.getX()-centre.getX()),2))  + Math.pow(Math.abs(endPoint.getY()-centre.getY()),2));
		}
		g2d.setColor(this.color);
		g2d.setStroke(new BasicStroke(this.strokeSize));
		
		
		if(this.getisFilled() ==false){
			g2d.drawOval(x-radius, y-radius, radius*2, radius*2);
		}else{
			g2d.fillOval(x-radius, y-radius, radius*2, radius*2);
		}
		
		
	}

	@Override
	public void setStart(Point p) {
		this.centre = p;
	}

	@Override
	public void setEnd(Point p) {
		// TODO Auto-generated method stub
		endPoint = p;
		
	}



}
