package gui;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import shapeFactory.FXRectangle;
import shapeFactory.ShapeAbstractFactory;
import shapes.Shape;

public class FXView implements View {
	
	public static Scene scene;
	public static BorderPane pane;
	public static Button toolbarRectangle;
	
	public void drawFrame(Stage stage) {
		stage.setTitle("Projet AL");
		//controller = Controller.getInstance();
		
		pane = new BorderPane();
		drawCommandBar();
		drawToolBar();
		
//		FXRectangle rTest = new FXRectangle();
//		
//		pane.setCenter(rTest.getR());
		
		scene = new Scene(pane, 600, 600);
		
		stage.setScene(scene);
		stage.show();
	}
	
	public void drawCommandBar() {
		HBox hbox = new HBox();
	    hbox.setSpacing(5);

	    Button buttonSave = new Button("Save");
	    Button buttonLoad = new Button("Load");
	    Button buttonUndo = new Button("Undo");
	    Button buttonRedo = new Button("Redo");
	    
	    hbox.getChildren().addAll(buttonSave, buttonLoad, buttonUndo, buttonRedo);
	    
	    pane.setTop(hbox);
	}
	
	public void drawToolBar() {
		
		VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10, 0, 0, 0));
	    vbox.setSpacing(5);

	    Button toolbarRectangle = new Button("Rectangle");
	    toolbarRectangle.setPrefSize(100, 20);  
	    Button toolbarPolygon = new Button("Regular Polygon"); 
	    toolbarPolygon.setPrefSize(100, 20);
	    
	    vbox.getChildren().addAll(toolbarRectangle, toolbarPolygon);
	    
	    pane.setLeft(vbox);
	}
	
	public void drawCenter(ArrayList<Shape> shapes) {
		pane.setCenter(shapes);
	}
	
	public void setupButtons(ShapeAbstractFactory factory, ArrayList<Shape> shapes) {
		toolbarRectangle.setOnAction(new EventHandler<ActionEvent>() {
	        @Override public void handle(ActionEvent e) {
	            shapes.add(factory.getRectangle());
	        	//pane.setCenter(((FXRectangle) factory.getRectangle()).getR());
	        }
	    });
	}
}
