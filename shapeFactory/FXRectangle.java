package shapeFactory;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;
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
	
	public void setupEdition() {
		ContextMenu contextMenu = new ContextMenu();
		 
	    MenuItem item1 = new MenuItem("Edition");
	    item1.setOnAction(new EventHandler<ActionEvent>() {
	        public void handle(ActionEvent event) {
	        	Dialog<RectangleSimple> dialog = new Dialog<>();
	    		dialog.setTitle("Properties Edition");
	    		dialog.setHeaderText("test header");

	    		Label label1 = new Label("Width : ");
	    		Label label2 = new Label("Height : ");
	    		TextField text1 = new TextField();
	    		TextField text2 = new TextField();
	    				
	    		GridPane grid = new GridPane();
	    		grid.add(label1, 1, 1);
	    		grid.add(text1, 2, 1);
	    		grid.add(label2, 1, 2);
	    		grid.add(text2, 2, 2);
	    		dialog.getDialogPane().setContent(grid);
	    				
	    		ButtonType buttonTypeOk = new ButtonType("Okay", ButtonData.OK_DONE);
	    		dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
	    		
	    		dialog.setResultConverter(new Callback<ButtonType, RectangleSimple>() {
	    			// handle the different buttons here (comparing names) to apply and finish when need be
	    			public RectangleSimple call(ButtonType b) {
	    				try {
	    					return new RectangleSimple(new Coordinates(0, 0), Double.parseDouble(text1.getText()), Double.parseDouble(text2.getText()));
	    				}
	    				catch (NumberFormatException | NullPointerException e) {
		        			System.out.println("Wrong input");
		        			return null;
		        		}
	    			}
	    		});
	    				
	    		Optional<RectangleSimple> result = dialog.showAndWait();
	    				
	    		if (result.isPresent()) {
	    			r.setWidth(result.get().getWidth());
	    			r.setHeight(result.get().getHeight());
	    		}
	        }
	    });
	    
	    contextMenu.getItems().addAll(item1);
	
	    r.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
	    	public void handle(ContextMenuEvent event) {
	    		contextMenu.show(r, event.getScreenX(), event.getScreenY());
	        }
	    });
	}
	
	public Rectangle getR() {
		return r;
	}
}
