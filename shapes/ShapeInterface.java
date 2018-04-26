package shapes;

import java.util.Iterator;

public interface ShapeInterface {
	// operations on a simple shape
	public void scale(int reductionRate);
	public void rotate(double angle);
	public void translation(Coordinates newPosition);

	// composite
	public void addShape(ShapeInterface s);
	public void removeShape(ShapeInterface s);
	public Iterator<ShapeInterface> getChildren(); //return null in ShapeSimple
}
