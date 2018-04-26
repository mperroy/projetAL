package gui;

import java.util.Iterator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import shapeFactory.FXRectangle;
import shapeFactory.FXRegularPolygon;
import shapeFactory.ShapeAbstractFactory;
import shapes.ShapeInterface;
// Test
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class FXView implements View {

	public static Scene scene;
	public static BorderPane pane;
	public static Pane centerPane;
	public static StackPane trash;

	public static HBox hbox;
	public static VBox vbox;
	
	public static Button buttonSave;
	public static Button buttonLoad;
	public static Button buttonUndo;
	public static Button buttonRedo;

	public static Button toolbarPolygon;
	//public static FXRegularPolygon toolbarPolygon;
	public static Rectangle trashIcon;
	
	// Test
	public static Rectangle toolbarRectangle;
	//public static FXRectangle toolbarRectangle;

	public void drawFrame(Stage stage) {
		stage.setTitle("Projet AL");

		pane = new BorderPane();
		
		centerPane = new Pane();
		drawCommandBar();
		
		centerPane.setStyle("-fx-border-color: black;-fx-border-width: 1;");
		
		pane.setCenter(centerPane);

		scene = new Scene(pane, 600, 600);

		stage.setScene(scene);
		stage.show();
	}

	public void drawCommandBar() {
		hbox = new HBox();
		hbox.setPadding(new Insets(0, 0, 10, 0));
	    hbox.setSpacing(5);

	    buttonSave = new Button("Save");
	    buttonLoad = new Button("Load");
	    buttonUndo = new Button("Undo");
	    buttonRedo = new Button("Redo");
	    
	    hbox.getChildren().addAll(buttonSave, buttonLoad, buttonUndo, buttonRedo);
	    
	    pane.setTop(hbox);
	}
	
	public void drawToolBar(Iterator<ShapeInterface> it) { // setOnMouseClicked on DrawShape. Toolbar setup from elsewhere ? (Memento)
		vbox = new VBox();
		vbox.setPadding(new Insets(0, 10, 10, 10));
	    vbox.setSpacing(5);


	    while (it.hasNext()) {
	    	ShapeInterface tmp = it.next();
			if (tmp instanceof FXRectangle)
				vbox.getChildren().add(((FXRectangle) tmp).getShape());
			else 
				vbox.getChildren().add(((FXRegularPolygon) tmp).getShape());
		}  
	    
	    // Get the mini rectangle from a toolbar
	    toolbarRectangle = new Rectangle(100, 30, Color.WHITE);
	    toolbarRectangle.setStroke(Color.BLACK);
	    
	    toolbarPolygon = new Button("Regular Polygon"); 
	    toolbarPolygon.setPrefSize(100, 20);
	    
	    vbox.getChildren().addAll(toolbarRectangle, toolbarPolygon);
	    
	    drawTrash();
	    
	    pane.setLeft(vbox);
	}
	
	public void drawTrash() {
		trash = new StackPane();
	    trashIcon = new Rectangle(50, 50);
	    //trashIcon.setFill(); Fill with png trash
	    trashIcon.setFill(Color.WHITE);
	    trashIcon.setStroke(Color.BLACK);
	    
	    trash.getChildren().add(trashIcon);
	    trash.setAlignment(Pos.BOTTOM_CENTER); // Why doesn't it work ?
	    vbox.getChildren().add(trash);
	}	

	public void setupButtons(ShapeAbstractFactory factory) {
		// replace these 2 buttons by the drag n drop from the toolbar while browsing vbox.getChildren()
		// onmousepressed, copy the shape and drag the new shape. centerpane needs a dragover / transfermode copy 
		// onmousepressed needs a way to cancel if it doesn't reach the right area
		
		toolbarRectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent e) {
	        	FXRectangle fxr = (FXRectangle) factory.getRectangle();
	        	fxr.setupMoveInBound(centerPane.getLayoutBounds());
	        	setupRightClick(fxr);
	            centerPane.getChildren().add(fxr.getShape());
	        }
	    });
		
		toolbarPolygon.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent e) {
	        	FXRegularPolygon fxrp = (FXRegularPolygon) factory.getRegularPolygon();
	        	fxrp.setupMoveInBound(centerPane.getLayoutBounds());
	        	setupRightClick(fxrp);
	            centerPane.getChildren().add(fxrp.getShape());
	        }
	    });
		//---------- Code Test pour la toolbar drag and drop -----------------//
				/*
				for(Node n :vbox.getChildren()) { 
					n.setOnMouseDragged(new EventHandler<MouseEvent>() { 
						public void handle(MouseEvent e) { 
							if (n instanceof Rectangle) { 
								FXRectangle fxr = (FXRectangle) factory.getRectangle(); 
								fxr.setupMoveInBound(vbox.getLayoutBounds());
								toolbarRectangle = fxr;
							}
							if (n instanceof Polygon) { 
								FXRegularPolygon fxrp = (FXRegularPolygon) factory .getRegularPolygon();
								fxrp.setupMoveInBound(vbox.getLayoutBounds());
								toolbarPolygon = fxrp;
							}
					    }
					});
				 centerPane.setOnMouseDragOver(new EventHandler<MouseEvent>() { 
						public void handle(MouseEvent e) { 
					    }
					});
					*/		
		trashIcon.setOnMouseDragReleased(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent e) {
	            centerPane.getChildren().remove(e.getSource());
	        }
	    });
		// setonmouseclicked save, load, undo, redo
	}
	
	public void setupRightClick(ShapeInterface shape) {
		ContextMenu contextMenu = new ContextMenu();
		Shape s; 
		if(shape instanceof FXRectangle) {
    		s = ((FXRectangle) shape).getShape();
    	}
    	else {
    		s = ((FXRegularPolygon) shape).getShape();
    	}
		
	    MenuItem item1 = new MenuItem("Edition");
	    item1.setOnAction(new EventHandler<ActionEvent>() {
	        public void handle(ActionEvent event) {
	        	if(shape instanceof FXRectangle) {
		    		setupEditionRectangle((FXRectangle) shape);		    		
	        	}
	        	else {
	        		setupEditionRegularPolygon((FXRegularPolygon) shape); 
	        	}	
	        }
	    });
	    
	    contextMenu.getItems().addAll(item1);
		
	    s.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
	    	public void handle(ContextMenuEvent event) {
	    		contextMenu.show(s, event.getScreenX(), event.getScreenY());
	        }
	    });
	}
	// Can be refactored more effectively
	public void setupEditionRectangle(FXRectangle fxr) {
		Stage dialog = new Stage();
    	GridPane grid = new GridPane();
    	Scene sceneDialog = new Scene(grid, 300, 200);

    	Label label1 = new Label("Width : ");
    	Label label2 = new Label("Height : ");
    	TextField text1 = new TextField();
    	TextField text2 = new TextField();
    	Button button1 = new Button("Apply");
    	Button button2 = new Button("Close");

    	grid.add(label1, 1, 1);
    	grid.add(text1, 2, 1);
    	grid.add(label2, 1, 2);
    	grid.add(text2, 2, 2);
    	grid.add(button1, 1, 3);
    	grid.add(button2, 2, 3);

    	button1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	try {
            		((Rectangle)fxr.getShape()).setWidth(Double.parseDouble(text1.getText()));
            	}catch(NumberFormatException | NullPointerException exc){}
            	
            	try {
                	((Rectangle)fxr.getShape()).setHeight(Double.parseDouble(text2.getText()));
            	}catch(NumberFormatException | NullPointerException exc){}
            }
        });
    	
    	button2.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent e) {
    			dialog.close();
    		}
    	});
    	
    	dialog.setScene(sceneDialog);
    	dialog.show();
	}
	
	public void setupEditionRegularPolygon(FXRegularPolygon fxrp) {
		Stage dialog = new Stage();
    	GridPane grid = new GridPane();
    	Scene sceneDialog = new Scene(grid, 300, 200);

    	Label label1 = new Label("Edge length  : ");
    	Label label2 = new Label("Edge number : ");
    	TextField text1 = new TextField();
    	TextField text2 = new TextField();
    	Button button1 = new Button("Apply");
    	Button button2 = new Button("Close");

    	grid.add(label1, 1, 1);
    	grid.add(text1, 2, 1);
    	grid.add(label2, 1, 2);
    	grid.add(text2, 2, 2);
    	grid.add(button1, 1, 3);
    	grid.add(button2, 2, 3);

    	button1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	try {
            		fxrp.setEdgeLength(Double.parseDouble(text1.getText()));
            	}catch(NumberFormatException | NullPointerException exc){}
            	
            	try {
        			fxrp.setEdgeNumber(Integer.parseInt(text2.getText()));
            	}catch(NumberFormatException | NullPointerException exc){}
            	
    			fxrp.drawVertices();
            }
        });
    	
    	button2.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent e) {
    			dialog.close();
    		}
    	});
    	
    	dialog.setScene(sceneDialog);
    	dialog.show();
	}
}
	    
	    