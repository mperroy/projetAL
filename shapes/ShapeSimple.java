package shapes;

import java.util.ArrayList;

import observer.ObserverShape;

public abstract class ShapeSimple implements Shape {
	private double rotation;
	private ColorSimple color;
	private Coordinates position; // position of point in top left corner
	private ArrayList<Coordinates> vertices;
	private Coordinates translation;
	private Coordinates rotationCenter;
	
	// Constructor ? Called in the abstract factory ?
	
	public ShapeSimple() {
		this.rotation = 0;
		this.color = new ColorSimple();
		this.position = new Coordinates();
		this.vertices = new ArrayList<Coordinates>();
		this.translation = new Coordinates();
		this.rotationCenter = new Coordinates();
	}
	
	public ShapeSimple(Coordinates position) {
		this.rotation = 0;
		this.color = new ColorSimple();
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

	public double getRotation() {
		return rotation;
	}

	public void setRotation(double rotation) {
		this.rotation = rotation;
	}

	public ColorSimple getColor() {
		return color;
	}

	public void setColor(ColorSimple color) {
		this.color = color;
	}

	public ArrayList<Coordinates> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Coordinates> vertices) {
		this.vertices = vertices;
	}

	public Coordinates getTranslation() {
		return translation;
	}

	public void setTranslation(Coordinates translation) {
		this.translation = translation;
	}

	public Coordinates getRotationCenter() {
		return rotationCenter;
	}

	public void setRotationCenter(Coordinates rotationCenter) {
		this.rotationCenter = rotationCenter;
	}

	public void setPosition(Coordinates position) {
		this.position = position;
	}
}
