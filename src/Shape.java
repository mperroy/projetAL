package src;

public interface Shape {
	public void scale(int reductionRate);
	public void rotate(double angle);
	public void translation(Coordinates newPosition);
	
	/**
	 * Observer
	 **/
	public void attach(ObserverShape o);
	public void detach(ObserverShape o);
	public void notifyObserver();
}
