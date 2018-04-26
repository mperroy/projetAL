package shapeFactory;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import shapes.Coordinates;
import shapes.RegularPolygonSimple;

public class FXRegularPolygon extends RegularPolygonSimple {
	private Polygon rP; // Regular polygon

	// Needs to be moved ? 
	private static double orgSceneX, orgSceneY;
	private static double orgTranslateX, orgTranslateY;
	
	public FXRegularPolygon() {
		super(new  Coordinates(200, 200), 50, 5);
		rP = new Polygon();
		
		drawVertices();
		
		rP.setFill(Color.WHITE);
		rP.setStroke(Color.BLACK);
	}
	
	public void setupMoveInBound(Bounds bounds) {
		rP.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {
                orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY();
                orgTranslateX = ((Polygon) t.getSource()).getTranslateX();
                orgTranslateY = ((Polygon) t.getSource()).getTranslateY();
            }
        });
        
        rP.setOnMouseDragged(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;
                    
                    if(newTranslateX+getMinX() > bounds.getMinX() && newTranslateX+getMaxX() < bounds.getMaxX()
                    		&& newTranslateY+getMinY() > bounds.getMinY() && newTranslateY+getMaxY() < bounds.getMaxY()) { 
                    	((Polygon)t.getSource()).setTranslateX(newTranslateX);
                    	((Polygon)t.getSource()).setTranslateY(newTranslateY);
                    }
                }
        });
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
				
		for(int i = 0 ; i < getEdgeNumber() ; i++) {
			x = getEdgeLength() * Math.cos(2*Math.PI*i/getEdgeNumber() + 60) + x_center;
			y = getEdgeLength() * Math.sin(2*Math.PI*i/getEdgeNumber() + 60) + y_center;
			rP.getPoints().addAll(x, y);
			
			vertices.add(new Coordinates(x, y));
		}
		setVertices(vertices);
	}
	
	private void clear() {
		while(!rP.getPoints().isEmpty()) {
			rP.getPoints().remove(0);
		}
		while(!getVertices().isEmpty()) {
			getVertices().remove(0);
		}
	}
}