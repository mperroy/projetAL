package shapeFactory;

import shapes.*;

public interface ShapeAbstractFactory {
	public RectangleSimple getRectangle();
	public RegularPolygonSimple getRegularPolygon();
}
