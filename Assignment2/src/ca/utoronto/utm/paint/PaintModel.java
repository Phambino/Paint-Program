package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;

/**
 * Paint Model is the base structure of the paint program
 * that holds all the shapes created given their attributes
 * @author Roman Huts, David Pham, Dean Wedgbury, Shahmir Durrani
 *
 */
public class PaintModel extends Observable {
	/**
	 * All the arraylist of all the shapes listed in the program
	 */
	private LinkedList<Shape> shapes = new LinkedList<Shape>();
	private LinkedList<Shape> undoneShapes = new LinkedList<Shape>();
	
	public void addShape(Shape s){
		shapes.add(s);
	}
	
	public LinkedList<Shape> getShapes(){
		return shapes;
	}
	
	public LinkedList<Shape> getundoneShapes(){
		return undoneShapes;
	}
	
	public void removeLastShape(){
		if (shapes.size() != 0) {
			shapes.remove(shapes.size()-1);
		}
	}
	
	public void undoShapes(){
		// implement exception catching for empty
		if (shapes.size() != 0) {
			undoneShapes.add(shapes.removeLast());
		}
	}
	
	public void redoShapes() {
		// implement exception catching for empty
		if (undoneShapes.size() != 0) {
			shapes.add(undoneShapes.removeLast());
		}
	}


}
