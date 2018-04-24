package shapeFactory;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import shapes.RectangleSimple;

public class FXRectangle extends RectangleSimple{
	private Rectangle r; // How to add it to the view ?
	
	public FXRectangle() {
		r = new Rectangle(200, 50, Color.BLACK);
		setWidth(r.getWidth());
		setHeight(r.getHeight());
		
		// Border curve for javafx. How to do it for RegularPolygon since it's drawn with lines ?
//		r.setArcHeight(15);
//	    r.setArcWidth(15);
	}
}
