package shapes;

import java.util.ArrayList;

public interface Memento {
	public ArrayList<ShapeInterface> getState();
	public void setState(ArrayList<ShapeInterface> state);
}
