package ca.utoronto.utm.paint;

public class ShapeFactory {
	public Shape getShape(String shapeType){
		if (shapeType == null){
			return null;
		}
		if (shapeType.equalsIgnoreCase("CIRCLE")){
			return new Circle();
		}
		if (shapeType.equalsIgnoreCase("RECTANGLE")){
			return new Rectangle();
		}
		if (shapeType.equalsIgnoreCase("SQUARE")){
			return new Square();
		}
		if (shapeType.equalsIgnoreCase("LINE")){
			return new Line();
		}
		if (shapeType.equalsIgnoreCase("POLYLINE")){
			return new Polyline();
		}
		if (shapeType.equalsIgnoreCase("SQUIGGLE")){
			return new Squiggle();
		}
		return null;
	}
	

}
