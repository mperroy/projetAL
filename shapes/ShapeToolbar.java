package shapes;

import java.util.ArrayList;
import java.util.Iterator;

public class ShapeToolbar {
	
	private ArrayList<Shape> shapeInToolbar;
	
	public ShapeToolbar() {
		shapeInToolbar = new ArrayList <Shape> ();
		shapeInToolbar.add(new RectangleSimple());
		//shapeInToolbar.add(new RegularPolygonSimple());
	}
	
	public void addToolbar(Shape s) {
		shapeInToolbar.add(s);
	}
	
	public void removeToolbar(Shape s) {
		shapeInToolbar.remove(s);
	}
	
	public Iterator<Shape> getChildren() {
		return new Iterator<Shape>() {

			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public Shape next() {
				return null;
			}	
		};
	}
}
