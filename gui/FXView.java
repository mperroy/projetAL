package gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import shapeFactory.FXRectangle;
import shapeFactory.FXRegularPolygon;
import shapeFactory.ShapeAbstractFactory;

// Test
import javafx.scene.shape.Rectangle;

public class FXView implements View {
	
	public static Scene scene;
	public static BorderPane pane;
	public static Pane centerPane;
	
	public static Button buttonSave;
	public static Button buttonLoad;
    public static Button buttonUndo;
    public static Button buttonRedo;
	
//	public static Button toolbarRectangle;
	public static Button toolbarPolygon;
	
	// Test
	public static Rectangle toolbarRectangle;
	
	public void drawFrame(Stage stage) {
		stage.setTitle("Projet AL");
		
		pane = new BorderPane();
		centerPane = new Pane();
		drawCommandBar();
		drawToolBar();
		pane.setCenter(centerPane);
		
		scene = new Scene(pane, 600, 600);
		
		stage.setScene(scene);
		stage.show();
	}
	
	public void drawCommandBar() {
		HBox hbox = new HBox();
	    hbox.setSpacing(5);

	    buttonSave = new Button("Save");
	    buttonLoad = new Button("Load");
	    buttonUndo = new Button("Undo");
	    buttonRedo = new Button("Redo");
	    
	    hbox.getChildren().addAll(buttonSave, buttonLoad, buttonUndo, buttonRedo);
	    
	    pane.setTop(hbox);
	}
	
	public void drawToolBar() { // setOnMouseClicked on DrawShape. Toolbar setup from elsewhere ? (Memento)
		
		VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10, 0, 0, 0));
	    vbox.setSpacing(5);


	    // Get the mini rectangle from a toolbar
	    toolbarRectangle = new Rectangle(100, 30, Color.WHITE);
	    toolbarRectangle.setStroke(Color.BLACK);
	    
	    toolbarPolygon = new Button("Regular Polygon"); 
	    toolbarPolygon.setPrefSize(100, 20);
	    
	    vbox.getChildren().addAll(toolbarRectangle, toolbarPolygon);
	    
	    pane.setLeft(vbox);
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
		
		// setonmouseclicked regularpolygon, save, load, undo, redo
	}
}
