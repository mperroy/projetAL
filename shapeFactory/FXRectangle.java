package shapeFactory;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import shapes.Coordinates;
import shapes.RectangleSimple;

public class FXRectangle extends RectangleSimple implements FXShape {
	private Rectangle r;

	public FXRectangle() {
		super(new Coordinates(0, 0), 100, 50);
		r = new Rectangle(getWidth(), getHeight(), Color.WHITE);
		r.setStroke(Color.BLACK);
	}

	public Shape getShape() {
		return r;
	}
}
