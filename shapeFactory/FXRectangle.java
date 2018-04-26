package shapeFactory;

import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import shapes.Coordinates;
import shapes.RectangleSimple;

public class FXRectangle extends RectangleSimple{
	private Rectangle r;
	
	// Needs to be moved ? 
	private static double orgSceneX, orgSceneY;
	private static double orgTranslateX, orgTranslateY;
	
	public FXRectangle() {
		super(new Coordinates(0, 0), 100, 50);
		r = new Rectangle(getWidth(), getHeight(), Color.WHITE);
		r.setStroke(Color.BLACK);
		
		// Border curve for javafx. 
//		r.setArcHeight(15);
//	    r.setArcWidth(15);
        
        // To group shapes, use setondragdetected to add to a group of shapes
	}
	
	public void setupMoveInBound(Bounds bounds) {
		
		r.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {
                orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY();
                orgTranslateX = ((Rectangle) t.getSource()).getTranslateX();
                orgTranslateY = ((Rectangle) t.getSource()).getTranslateY();
            }
        });
        
        r.setOnMouseDragged(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;
                    if(newTranslateX+getMinX() > bounds.getMinX() && newTranslateX+getMaxX() < bounds.getMaxX()
                    		&& newTranslateY+getMinY() > bounds.getMinY() && newTranslateY+getMaxY() < bounds.getMaxY()) { 
                    	((Rectangle)t.getSource()).setTranslateX(newTranslateX);
                    	((Rectangle)t.getSource()).setTranslateY(newTranslateY);
                    }
                }
        });
	}
	
	public Rectangle getR() {
		return r;
	}
}
