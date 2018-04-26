package shapes;

import java.util.ArrayList;

public class Memento {
	private ArrayList<ShapeInterface> state;

	public Memento(ArrayList<ShapeInterface> state) {
		this.state = state;
	}

	public ArrayList<ShapeInterface> getState() {
		return state;
	}

}
