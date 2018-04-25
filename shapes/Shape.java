package shapes;

import java.util.Iterator;

import observer.ObserverShape;

public interface Shape {
	//operations on a simple shape
	public void scale(int reductionRate);
	public void rotate(double angle);
	public void translation(Coordinates newPosition);
	
	//to make group of shape
	public void addShape(Shape s); // exception in ShapeSimple
	public void removeShape(Shape u); // nothing in UnitSimple
	public Iterator<Shape> getChildren(); //return null in ShapeSimple
	
	/**
	 * Observer
	 **/
	public void attach(ObserverShape o);
	public void detach(ObserverShape o);
	public void notifyObserver();
}
