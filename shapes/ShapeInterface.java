package shapes;

import java.util.Iterator;

public interface ShapeInterface {
	public void scale(int reductionRate);
	public void rotate(double angle);
	public void translation(Coordinates newPosition);

	public double getMinX();
	public double getMaxX();
	public double getMinY();
	public double getMaxY();
		
	// Composite
	public void addShape(ShapeInterface s);
	public void removeShape(ShapeInterface s);
	public Iterator<ShapeInterface> getChildren();
	
	// Prototype
	public ShapeInterface clone();
}
