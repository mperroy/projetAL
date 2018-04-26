package shapes;

import java.util.ArrayList;
import java.util.Iterator;

import observer.ObserverShape;

public abstract class ShapeSimple implements ShapeInterface {
	private double rotation;
	private ColorSimple color;
	private Coordinates position; // position of point in top left corner
	private ArrayList<Coordinates> vertices; //always position first in ?
	private Coordinates translation; // � enlever si pas utile
	private Coordinates rotationCenter;

	// Constructor ? Called in the abstract factory ?

	public ShapeSimple() { //initialisation to null
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
		this.vertices = new ArrayList<Coordinates>(); //add other vertices ?
		this.translation = new Coordinates();
		this.rotationCenter = new Coordinates(); //calculate real coordinate of this point ?
	}

	@Override
	public void scale(int reductionRate) {
		// change position of the vertices accordingly ? How ?
	}

	@Override
	public void rotate(double angle) {
		this.rotation += angle;
		double angleRad = angle *Math.PI/180;
		for(Coordinates point : vertices) {
			point.setX((point.getX() - rotationCenter.getX()) * Math.cos(angleRad) - (point.getY() - rotationCenter.getY()) * Math.sin(angleRad) + rotationCenter.getX());
			point.setY((point.getY() - rotationCenter.getY()) * Math.cos(angleRad) - (point.getX() - rotationCenter.getX()) * Math.sin(angleRad) + rotationCenter.getY());
		}
		//If position always first in vertices
		position = vertices.get(0);
	}

	@Override
	public void translation(Coordinates newPosition) {
		// leave it at that for now
	}
	
	//only for regularPolygon ?
	public void addVertix(Coordinates position) {
		vertices.add(position);
	}
	
    //getters and setters	
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

	public Coordinates getPosition() {
		return position;
	}
	
	public void setPosition(Coordinates position) {
		this.position = position;
	}
	
	// Other function
	
	public double getMinX() {
		double res = vertices.get(0).getX();
		for(Coordinates c : vertices) {
			if(c.getX() < res)
				res = c.getX();
		}
		return res;
	}
	
	public double getMaxX() {
		double res = vertices.get(0).getX();
		for(Coordinates c : vertices) {
			if(c.getX() > res)
				res = c.getX();
		}
		return res;
	}
	
	public double getMinY() {
		double res = vertices.get(0).getY();
		for(Coordinates c : vertices) {
			if(c.getY() < res)
				res = c.getY();
		}
		return res;
	}
	
	public double getMaxY() {
		double res = vertices.get(0).getY();
		for(Coordinates c : vertices) {
			if(c.getY() > res)
				res = c.getY();
		}
		return res;
	}
	
	//function for shapeGroup
	public void addShape(ShapeInterface s) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	public void removeShape(ShapeInterface s) {}
	
	public Iterator<ShapeInterface> getChildren() {
		return new Iterator<ShapeInterface>() {

			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public ShapeInterface next() {
				return null;
			}
			
		};
	}
}
