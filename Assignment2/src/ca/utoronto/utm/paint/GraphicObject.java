package ca.utoronto.utm.paint;

import java.awt.Color;

/**
 * Model a GraphicObject. Each GraphicObject has a color color and stroke size
 * strokeSize.
 * 
 * @author Roman Huts
 *
 */
public class GraphicObject {
	private Color color;
	private int strokeSize; // Always set to 1 <= strokeSize <= 16

	/**
	 * Construct a GraphicObject with color set to the default value of white
	 * and strokeSize set to the default value of 1.
	 */
	public GraphicObject() {
		this.color = Color.WHITE; // default color
		this.strokeSize = 1; // default size
	}

	/**
	 * Set the color of this to Color c.
	 * 
	 * @param c
	 *            the target color
	 */
	public void setColor(Color c) {
		this.color = c;
	}

	/**
	 * @return the color of this
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Set the stroke size of this to size.
	 * 
	 * @param size
	 *            the target size
	 */
	public void setSize(int size) {
		this.strokeSize = size;
	}

	/**
	 * @return the strokeSize of this
	 */
	public int getSize() {
		return this.strokeSize;
	}

}
