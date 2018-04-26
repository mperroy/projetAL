package shapeFactory;

import java.util.ArrayList;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Callback;
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
	
	public void setupEdition() {
		ContextMenu contextMenu = new ContextMenu();
		 
	    MenuItem item1 = new MenuItem("Edition");
	    item1.setOnAction(new EventHandler<ActionEvent>() {
	        public void handle(ActionEvent event) {
	        	Dialog<RegularPolygonSimple> dialog = new Dialog<>();
	    		dialog.setTitle("Properties Edition");
	    		dialog.setHeaderText("test header");

	    		Label label1 = new Label("Edge length : ");
	    		Label label2 = new Label("Edge number : ");
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
	    		
	    		dialog.setResultConverter(new Callback<ButtonType, RegularPolygonSimple>() {
	    			// handle the different buttons here (comparing names) to apply and finish when need be
	    			public RegularPolygonSimple call(ButtonType b) {
	    				try {
	    					return new RegularPolygonSimple(new Coordinates(0, 0), Double.parseDouble(text1.getText()), Integer.parseInt(text2.getText()));
	    				}
	    				catch (NumberFormatException | NullPointerException e) {
		        			System.out.println("Wrong input");
		        			return null;
		        		}
	    			}
	    		});
	    				
	    		Optional<RegularPolygonSimple> result = dialog.showAndWait();
	    				
	    		if (result.isPresent()) {
	    			setEdgeLength(result.get().getEdgeLength());
	    			setEdgeNumber(result.get().getEdgeNumber());
	    			drawVertices();
	    		}
	        }
	    });
	    
	    contextMenu.getItems().addAll(item1);
	
	    rP.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
	    	public void handle(ContextMenuEvent event) {
	    		contextMenu.show(rP, event.getScreenX(), event.getScreenY());
	        }
	    });
	}
	
	public Polygon getRP() {
		return rP;
	}
	
	private void drawVertices() {		
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