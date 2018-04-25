package shapes;

import java.util.ArrayList;
import java.util.Iterator;

import observer.ObserverShape;

public class ShapeGroup implements Shape { // Composite de Shape

	private ArrayList<Shape> shapeMember;
	
	public ShapeGroup() {
		shapeMember = new ArrayList<Shape>();
	}
	@Override
	public void scale(int reductionRate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rotate(double angle) {
		for(Shape s : shapeMember)
			s.rotate(angle);
	}

	@Override
	public void addShape(Shape u) {
		this.shapeMember.add(u);
	}

	@Override
	public void removeShape(Shape u) {
		this.shapeMember.remove(u);
	}

	@Override
	public Iterator<Shape> getChildren() {
		return shapeMember.iterator();
	}
	@Override
	public void translation(Coordinates newPosition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attach(ObserverShape o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void detach(ObserverShape o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub

	}

}
