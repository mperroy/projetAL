package shapes;

import java.util.ArrayList;
import java.util.Iterator;

import observer.ObserverShape;

public class ShapeGroup implements ShapeInterface { // Composite de Shape

	private ArrayList<ShapeInterface> shapeMember;
	
	public ShapeGroup() {
		shapeMember = new ArrayList<ShapeInterface>();
	}
	@Override
	public void scale(int reductionRate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rotate(double angle) {
		for(ShapeInterface s : shapeMember)
			s.rotate(angle);
	}

	@Override
	public void addShape(ShapeInterface u) {
		this.shapeMember.add(u);
	}

	@Override
	public void removeShape(ShapeInterface u) {
		this.shapeMember.remove(u);
	}

	@Override
	public Iterator<ShapeInterface> getChildren() {
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
