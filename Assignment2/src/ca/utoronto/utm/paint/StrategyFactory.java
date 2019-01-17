package ca.utoronto.utm.paint;

public class StrategyFactory {
	public ShapeManipulatorStrategy getStrategy(String StrategyType, PaintPanel panel){
		if (StrategyType == null){
			return null;
		}
		if (StrategyType.equalsIgnoreCase("CIRCLE")){
			return new CircleStrategy(panel);
		}
		if (StrategyType.equalsIgnoreCase("RECTANGLE")){
			return new RectangleStrategy(panel);
		}
		if (StrategyType.equalsIgnoreCase("SQUARE")){
			return new SquareStrategy(panel);
		}
		if (StrategyType.equalsIgnoreCase("LINE")){
			return new LineStrategy(panel);
		}
		if (StrategyType.equalsIgnoreCase("POLYLINE")){
			return new PolylineStrategy(panel);
		}
		if (StrategyType.equalsIgnoreCase("SQUIGGLE")){
			return new SquiggleStrategy(panel);
		}
		return null;
	}

}
