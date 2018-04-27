package shapeFactory;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import shapes.Coordinates;
import shapes.RectangleSimple;

public class FXRectangle extends RectangleSimple implements FXShape {
	private Rectangle r;

	public FXRectangle(Coordinates position, double width, double height) {
		super(position, width, height);
		r = new Rectangle(getWidth(), getHeight(), Color.WHITE);
		r.setStroke(Color.BLACK);
	}
	
	public FXRectangle(RectangleSimple rect) {
		super(rect);
		r = new Rectangle(getWidth(), getHeight(), Color.WHITE);
		r.setStroke(Color.BLACK);
	}
	
	public void setWidth(double width) {
		super.setWidth(width);
		r.setWidth(width);
	}
	
	public void setHeight(double height) {
		super.setHeight(height);
		r.setHeight(height);
	}
	
	public void setBorderCurve(double borderCurve) {
		super.setBorderCurve(borderCurve);
		r.setArcHeight(borderCurve);
		r.setArcWidth(borderCurve);
	}
	
	public void translation(Coordinates newPosition) {
		super.translation(newPosition);
		r.setTranslateX(newPosition.getX());
		r.setTranslateY(newPosition.getY());
	}

	public Shape getShape() {
		return r;
	}
}
