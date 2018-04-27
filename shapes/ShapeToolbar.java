package shapes;

import java.util.ArrayList;
import java.util.Iterator;

public class ShapeToolbar {

	private ArrayList<ShapeInterface> shapeInToolbar;

	public ShapeToolbar() {
		shapeInToolbar = new ArrayList <ShapeInterface> ();
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
	
	public int nbElement() {
		int cpt = 0;
		for(ShapeInterface s : shapeInToolbar)
			cpt += 1;
		return cpt;
	}
	public MementoToolbar createMemento() {
		return new MementoToolbar(shapeInToolbar);
	}

	public void setMemento(MementoToolbar m) {
		shapeInToolbar = m.getState();
	}
}
