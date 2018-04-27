package shapeFactory;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import shapes.Coordinates;
import shapes.RegularPolygonSimple;

public class FXRegularPolygon extends RegularPolygonSimple implements FXShape {
	private Polygon rP; // Regular polygon

	public FXRegularPolygon() {
		super(new Coordinates(50, 50), 50, 5);
		rP = new Polygon();

		drawVertices();

		rP.setFill(Color.WHITE);
		rP.setStroke(Color.BLACK);
	}

	public FXRegularPolygon(RegularPolygonSimple poly) {
		super(poly);
		rP = new Polygon();

		drawVertices();

		rP.setFill(Color.WHITE);
		rP.setStroke(Color.BLACK);

	}

	public void setEdgeLength(double edgeLength) {
		super.setEdgeLength(edgeLength);
		drawVertices();
	}

	public void setEdgeNumber(int edgeNumber) {
		super.setEdgeNumber(edgeNumber);
		drawVertices();
	}


	public void translation(Coordinates newPosition) {
		super.translation(newPosition);
		rP.setTranslateX(newPosition.getX());
		rP.setTranslateY(newPosition.getY());
	}

	public Shape getShape() {
		return rP;
	}

	public void drawVertices() {
		setupVertix();
		clear();

		for (Coordinates c : getVertices()) {
			rP.getPoints().addAll(c.getX(), c.getY());
		}
	}

	private void clear() {
		while(!rP.getPoints().isEmpty()) {
			rP.getPoints().remove(0);
		}		
	}

}