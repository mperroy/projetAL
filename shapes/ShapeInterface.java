package shapes;

import java.util.Iterator;

public interface ShapeInterface {
	// operations on a simple shape
	public void scale(int reductionRate);
	public void rotate(double angle);
	public void translation(Coordinates newPosition);

	// to make group of shape
	public void addShape(ShapeInterface s);
	public void removeShape(ShapeInterface d);
	public Iterator<ShapeInterface> getChildren(); // return null in ShapeSimple

}
