package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Square implements Shape {
	
	private Point corner;
	private int sideLength;
	private Color color;
	private int strokeSize;
	private Point endPoint;
	private Boolean isFilled = false;
	
	public Square(){
		sideLength = 0;
	}
	
	public Square(Point corner, int sidelength) {
		this.corner = corner;
		this.sideLength= sidelength;
	}
	public Point getCorner(){
		return corner;
	}
	public void setCorner(Point corner){
		this.corner = corner;
	}
	public int getLength(){
		return sideLength;
	}
	public void setLength(int length){
		this.sideLength = length;
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
		int endX, endY, x, y, startX, startY;
		endX = endPoint.getX();
		endY = endPoint.getY();
		
		startX = corner.getX();
		startY = corner.getY();
		
		x = startX;
		y = startY;
		
		Point topLeft = new Point(x,y);
		
		int width = Math.abs(x - endX);
		int height = Math.abs(y - endY);
		int smallest = Math.min(width, height);
		
		if ((endX < startX) && (endY>startY)) {
			topLeft = new Point(x-smallest,y);
		}
		else if ((endX < startX) && (endY<startY)) {
			topLeft = new Point(x-smallest,y-smallest);
		}
		else if ((endX > startX) && (endY<startY)) {
			topLeft = new Point(x,y-smallest);
		}
		g2d.setColor(this.color);
		g2d.setStroke(new BasicStroke(this.strokeSize));
		if(this.getisFilled() == false){
			g2d.drawRect(topLeft.getX(), topLeft.getY(), smallest, smallest);
		}else{
			g2d.fillRect(topLeft.getX(), topLeft.getY(), smallest, smallest);
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
		this.corner = p;
		
	}

	@Override
	public void setEnd(Point p) {
		// TODO Auto-generated method stub
		endPoint = p;
		
	}
}
