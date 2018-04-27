package shapeFactory;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import shapes.Coordinates;
import shapes.RegularPolygonSimple;

public class FXRegularPolygon extends RegularPolygonSimple implements FXShape {
	private Polygon rP; // Regular polygon

	public FXRegularPolygon() {
		super(new Coordinates(200, 200), 50, 5);
		rP = new Polygon();

		drawVertices();

		rP.setFill(Color.WHITE);
		rP.setStroke(Color.BLACK);
	}
	
	public Shape getShape() {
		return rP;
	}

	public void drawVertices() {
		double x_center = getPosition().getX();
		double y_center = getPosition().getY();
		double x;
		double y;

		ArrayList<Coordinates> vertices = new ArrayList<Coordinates>();

		clear();

		for (int i = 0; i < getEdgeNumber(); i++) {
			x = getEdgeLength()
					* Math.cos(2 * Math.PI * i / getEdgeNumber() + 60)
					+ x_center;
			y = getEdgeLength()
					* Math.sin(2 * Math.PI * i / getEdgeNumber() + 60)
					+ y_center;
			rP.getPoints().addAll(x, y);

			vertices.add(new Coordinates(x, y));
		}
		setVertices(vertices);
	}

	private void clear() {
		while (!rP.getPoints().isEmpty()) {
			rP.getPoints().remove(0);
		}
		while (!getVertices().isEmpty()) {
			getVertices().remove(0);
		}
	}
}