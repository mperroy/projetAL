package gui;

import java.util.Iterator;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import shapeFactory.FXRectangle;
import shapeFactory.FXRegularPolygon;
import shapeFactory.ShapeAbstractFactory;
import shapes.RectangleSimple;
import shapes.RegularPolygonSimple;
import shapes.Shape;
import shapes.ShapeSimple;
// Test
import javafx.scene.shape.Rectangle;

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

	// public static Button toolbarRectangle;
	public static Button toolbarPolygon;
	
	public static Rectangle trashIcon;
	
	// Test
	public static Rectangle toolbarRectangle;

	public void drawFrame(Stage stage) {
		stage.setTitle("Projet AL");

		pane = new BorderPane();
		
		centerPane = new Pane();
		drawCommandBar();
		
		// drawToolBar(); commenter pour le test
		drawTrash();
		centerPane.setStyle("-fx-border-color: black;-fx-border-width: 2;\n");
		
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
	
	public void drawToolBar(Iterator<Shape> it) { // setOnMouseClicked on DrawShape. Toolbar setup from elsewhere ? (Memento)
		vbox = new VBox();
		vbox.setPadding(new Insets(0, 10, 10, 10));
	    vbox.setSpacing(5);


	    while (it.hasNext()) {
			/**
			 * TODO : comment traduire les shapes de l'arraylist en �l�ment de la toolbar
			 */
			if (it.next() instanceof FXRectangle)
				vbox.getChildren().add(((FXRectangle) it.next()).getR());
		}
		/*
		 * else vbox.getChildren().add(((FXRegularPolygon) it.next()).getRP()); }
		 */    
	    
//	    // Get the mini rectangle from a toolbar
//	    toolbarRectangle = new Rectangle(100, 30, Color.WHITE);
//	    toolbarRectangle.setStroke(Color.BLACK);
//	    
//	    toolbarPolygon = new Button("Regular Polygon"); 
//	    toolbarPolygon.setPrefSize(100, 20);
//	    
//	    vbox.getChildren().addAll(toolbarRectangle, toolbarPolygon);
	    
	    pane.setLeft(vbox);
	}
	
	public void drawTrash() {
		trash = new StackPane();
	    trashIcon = new Rectangle(50, 50);
	    //trashIcon.setFill(); Fill with png trash
	    trashIcon.setFill(Color.WHITE);
	    trashIcon.setStroke(Color.BLACK);
	    
	    //trash.getChildren().add(trashIcon);
	    trash.setAlignment(Pos.BOTTOM_CENTER); // Why doesn't it work ?
	    centerPane.getChildren().add(trashIcon); // trash
	}	

	public void setupButtons(ShapeAbstractFactory factory) {
		toolbarRectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent e) {
	            centerPane.getChildren().add(((FXRectangle) factory.getRectangle()).getR());
	        }
	    });
		
		toolbarPolygon.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent e) {
	            centerPane.getChildren().add(((FXRegularPolygon) factory.getRegularPolygon()).getRP());
	        }
	    });
				
		trashIcon.setOnMouseDragReleased(new EventHandler<MouseEvent>() {
	        public void handle(MouseEvent e) {
	            centerPane.getChildren().remove(e.getSource());
	        }
	    });
		// setonmouseclicked regularpolygon, save, load, undo, redo
	}
}