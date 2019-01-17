package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
/**
 * This class represents a continuous line represented by a the
 * continuous drag of the mouse and the constant creation of
 * lines.
 * 
 * @author David
 *
 */
public class Squiggle implements Shape {

	private ArrayList<Point> squigglePoints; // An Arraylist that stores all the points for a squiggle
	private Color color;
	private int strokeSize;
	private Boolean isFilled = false;
	
	/**
	 * Initializes a Squiggle that has an arraylist of points
	 */
	public Squiggle(){
		this.squigglePoints=new ArrayList<Point>();
	}
	

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public void setColor(Color c) {
		this.color = c;
	}

	@Override
	public int getStrokeSize() {
		return this.strokeSize;
	}

	@Override
	public void setStrokeSize(int size) {
		this.strokeSize = size;
	}
	
	@Override
	public void setStart(Point p) {
		this.squigglePoints.add(p); 
	}
	
	@Override
	public void setEnd(Point p) {
		this.squigglePoints.add(p); 
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
		for (int i = 1; i <= this.squigglePoints.size() - 1; i++){
			int p1 = this.squigglePoints.get(i-1).getX();
			int p2 = this.squigglePoints.get(i-1).getY();
			int p3 = this.squigglePoints.get( i ).getX();
			int p4 = this.squigglePoints.get( i ).getY();
			
			g2d.setColor(this.color);
			g2d.setStroke(new BasicStroke(this.strokeSize));
			g2d.drawLine(p1, p2, p3, p4);
		}
	}
}
