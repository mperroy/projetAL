package shapeFactory;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import shapes.Coordinates;
import shapes.RegularPolygonSimple;

public class FXRegularPolygon extends RegularPolygonSimple {
	private Polygon rP; // Regular polygon

	// Needs to be moved ? 
	private static double orgSceneX, orgSceneY;
	private static double orgTranslateX, orgTranslateY;
	
	public FXRegularPolygon() {
		super(new  Coordinates(200, 200), 50, 5);
		
		drawVertices(getPosition());
		
		rP.setFill(Color.WHITE);
		rP.setStroke(Color.BLACK);
		
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
                     
                    ((Polygon)t.getSource()).setTranslateX(newTranslateX);
                    ((Polygon)t.getSource()).setTranslateY(newTranslateY);
                }
        });
	}
	
	public Polygon getRP() {
		return rP;
	}
	
	private void drawVertices(Coordinates pos) {
		rP = new Polygon();
		
		double x_center = pos.getX();
		double y_center = pos.getY();
		double x;
		double y;
		
		for(int i = 0 ; i < getEdgeNumber() ; i++) {
			x = getEdgeLength() * Math.cos(2*Math.PI*i/getEdgeNumber() + 60) + x_center;
			y = getEdgeLength() * Math.sin(2*Math.PI*i/getEdgeNumber() + 60) + y_center;
			rP.getPoints().addAll(x, y);
		}
	}
}