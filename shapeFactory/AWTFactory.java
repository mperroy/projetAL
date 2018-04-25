package shapeFactory;

import shapes.RectangleSimple;
import shapes.RegularPolygonSimple;

public class AWTFactory implements ShapeAbstractFactory {

	public RectangleSimple getRectangle() {
		return new AWTRectangle();
	}

	public RegularPolygonSimple getRegularPolygon() {
		return new AWTRegularPolygon();
	}

}
