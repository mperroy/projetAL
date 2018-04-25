package shapeFactory;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import shapes.RectangleSimple;

public class FXRectangle extends RectangleSimple{
	private Rectangle r;
	
	// Needs to be moved ? 
	private static double orgSceneX, orgSceneY;
	private static double orgTranslateX, orgTranslateY;
	
	public FXRectangle() {
		r = new Rectangle(100, 50, Color.WHITE);
		r.setStroke(Color.BLACK);
		setWidth(r.getWidth());
		setHeight(r.getHeight());
		
		// Border curve for javafx. How to do it for RegularPolygon since it's drawn with lines ?
//		r.setArcHeight(15);
//	    r.setArcWidth(15);
		
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
                     
                    ((Rectangle)t.getSource()).setTranslateX(newTranslateX);
                    ((Rectangle)t.getSource()).setTranslateY(newTranslateY);
                }
        });
        
        // To group shapes, use setondragdetected to add to a group of shapes
	}
	
	public Rectangle getR() {
		return r;
	}
}
