package shapes;

import java.util.Iterator;

import observer.ObserverShape;

public interface ShapeInterface {
	//operations on a simple shape
	public void scale(int reductionRate);
	public void rotate(double angle);
	public void translation(Coordinates newPosition);
	
	//to make group of shape
	public void addShape(ShapeInterface s); // exception in ShapeSimple
	public void removeShape(ShapeInterface u); // nothing in UnitSimple
	public Iterator<ShapeInterface> getChildren(); //return null in ShapeSimple
	
	/**
	 * Observer
	 **/
	public void attach(ObserverShape o);
	public void detach(ObserverShape o);
	public void notifyObserver();
}
