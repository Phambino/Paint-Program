package ca.utoronto.utm.paint;

import javax.swing.*;  
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class PaintPanel extends JPanel implements Observer, MouseMotionListener, MouseListener  {
	private int i=0;
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view

	private String mode; 
	private Shape shape;
	private ShapeFactory shapefactory;
	private StrategyFactory strategyFactory;
	private ShapeManipulatorStrategy strategy;
	
	private boolean isFilled;
	private Color selectedColor;
	private int selectedSize;
	
	public PaintPanel(PaintModel model, View view){
		shapefactory = new ShapeFactory();
		strategyFactory = new StrategyFactory();
		
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(300,300));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.selectedColor = Color.BLACK;
		
		this.mode= null; // bad code here?
		
		this.model = model;
		this.model.addObserver(this);
		
		this.view=view;
	}
	
	public Shape getShape() {
		return shape;
	}
	
	public void setShape(Shape s) {
		shape = s;
	}
	
	public ShapeFactory getFactory() {
		return shapefactory;
	}
	
	public StrategyFactory getStrategyFactory(){
		return strategyFactory;
	}
	
	public String getMode() {
		return mode;
	}
	
	public PaintModel getModel() {
		return model;
	}
	/**
	 * Set the selected color selectedColor of this.
	 * 
	 * @param color the target color
	 */
	public void setColor(Color color) {
		this.selectedColor = color;
	}
	
	/**
	 * @return the selected color of this
	 */
	public Color getColor() {
		return this.selectedColor;
	}
	
	
	/**
	 * Set whether or not the new shapes will be filled.
	 * 
	 * @param a boolean indicating whether or not the shape will be filled.
	 */
	public void setisFilled(Boolean isFilled) {
		this.isFilled = isFilled;	
	}
	
	/**
	 * @return whether or not shapes are being filled
	 */
	public Boolean getisFilled() {
		return this.isFilled;
	}
	public void setStrokeSize(int size){
		this.selectedSize = size;
	}
	
	public int getStrokeSize(){
		return this.selectedSize;
	}
	
	/**
	 *  View aspect of this
	 */
	public void paintComponent(Graphics g) {
		// Use g to draw on the JPanel, lookup java.awt.Graphics in
		// the javadoc to see more of what this can do for you!!
		
        super.paintComponent(g); //paint background
        Graphics2D g2d = (Graphics2D) g; // lets use the advanced api
		// setBackground (Color.blue); 
		// Origin is at the top left of the window 50 over, 75 down
		//g2d.setStroke(new BasicStroke());
        g2d.drawString ("i="+i, 50, 75);
		i=i+1;
		
		// Draw Shapes
		LinkedList<Shape> shapes = this.model.getShapes();
		for(Shape s: shapes){
			s.execute(g2d);
		}
		g2d.dispose();
	}

	@Override
	public void update(Observable o, Object arg) {
		this.repaint(); 
	}
	
	/**
	 *  Controller aspect of this
	 */
	public void setMode(String mode){
		this.mode=mode;
	}
	
	public void setStrategy(String Strategy){
		this.strategy = strategyFactory.getStrategy(Strategy, this);
	}
	

	@Override
	public void mouseMoved(MouseEvent e) {
		if (strategy != null) {
			strategy.mouseMoved(e);
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if (strategy != null) {
			strategy.mouseDragged(e);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (strategy != null) {
			strategy.mousePressed(e);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (strategy != null) {
			strategy.mouseReleased(e);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (strategy != null) {
			strategy.mouseEntered(e);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (strategy != null) {
			strategy.mouseExited(e);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}
}
