package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;

public interface Shape {
	
	public void setStart(Point p);
	public void setEnd(Point p);
	public Color getColor();
	public void setColor(Color c);
	public int getStrokeSize();
	public Boolean getisFilled();
	public void setisFilled(Boolean isFilled);
	public void setStrokeSize(int size);
	public void execute(Graphics2D g2d);

}
