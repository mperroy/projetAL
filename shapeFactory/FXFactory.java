package shapeFactory;

import shapes.Coordinates;
import shapes.RectangleSimple;
import shapes.RegularPolygonSimple;

public class FXFactory implements ShapeAbstractFactory {

	public RectangleSimple getRectangle() {
		return new FXRectangle(new Coordinates(0, 0), 100, 50);
	}

	public RegularPolygonSimple getRegularPolygon() {
		return new FXRegularPolygon();
	}

}
