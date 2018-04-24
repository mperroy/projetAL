package shapeFactory;

import shapes.RectangleSimple;
import shapes.RegularPolygonSimple;

public class FXFactory implements ShapeAbstractFactory {

	public RectangleSimple getRectangle() {
		return new FXRectangle();
	}

	public RegularPolygonSimple getRegularPolygon() {
		return new FXRegularPolygon();
	}

}
