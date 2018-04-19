package src;

import java.util.ArrayList;

public abstract class ShapeSimple implements Shape {
	private double rotation;
	private Color color;
	private Coordinates position; // position of point in top left corner
	private ArrayList<Coordinates> vertices;
	private Coordinates translation;
	private Coordinates rotationCenter;
	
	// Constructor ? Called in the abstract factory ?
	
	public ShapeSimple() {
		this.rotation = 0;
		this.color = new Color();
		this.position = new Coordinates();
		this.vertices = new ArrayList<Coordinates>();
		this.translation = new Coordinates();
		this.rotationCenter = new Coordinates();
	}
	
	public ShapeSimple(Coordinates position) {
		this.rotation = 0;
		this.color = new Color();
		this.position = position;
		this.vertices = new ArrayList<Coordinates>();
		this.translation = new Coordinates();
		this.rotationCenter = new Coordinates();
	}
	
	@Override
	public void scale(int reductionRate) {
		// change position of the vertices accordingly ? How ?
	}

	@Override
	public void rotate(double angle) {
		this.rotation += angle;
		// Change vertices position ?
	}

	@Override
	public void translation(Coordinates newPosition) {
		// leave it at that for now
	}
	
	public Coordinates getPosition() {
		return position;
	}
	
	public void addVertix(Coordinates position) {
		vertices.add(position);
	}

	/**
	 * Observer
	 **/
	
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
