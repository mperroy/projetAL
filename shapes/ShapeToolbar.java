package shapes;

import java.util.ArrayList;
import java.util.Iterator;

public class ShapeToolbar {

	private ArrayList<ShapeInterface> shapeInToolbar;

	public ShapeToolbar() {
		shapeInToolbar = new ArrayList<ShapeInterface>();
	}

	public void add(ShapeInterface s) {
		shapeInToolbar.add(s);
	}

	public void remove(ShapeInterface s) {
		shapeInToolbar.remove(s);
	}

	public Iterator<ShapeInterface> getChildren() {
		return shapeInToolbar.iterator();
	}

	public Memento createMemento() {
		return new Memento(shapeInToolbar);
	}

	public void setMemento(Memento m) {
		shapeInToolbar = m.getState();
	}
}
