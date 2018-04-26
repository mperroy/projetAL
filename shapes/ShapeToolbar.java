package shapes;

import java.util.ArrayList;
import java.util.Iterator;

public class ShapeToolbar {
	
	private ArrayList<Shape> shapeInToolbar; // ShapeGroup et pas ArrayList ?
	
	public ShapeToolbar() {
		shapeInToolbar = new ArrayList <Shape> ();
		//shapeInToolbar.add(new RectangleSimple());
		//shapeInToolbar.add(new RegularPolygonSimple());
	}
	
	public void add(Shape s) {
		shapeInToolbar.add(s);
	}
	
	public void remove(Shape s) {
		shapeInToolbar.remove(s);
	}
	
	public Iterator<Shape> getChildren() {
		return shapeInToolbar.iterator();
	}
}
