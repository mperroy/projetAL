package gui;

import shapeFactory.*;
import shapes.Shape;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;

public class FXController extends Application implements Controller {
	private ShapeAbstractFactory factory;
	private View view;
	private ArrayList<Shape> shapes; 
	
	public FXController() {
		factory = new FXFactory();
		view = new FXView();
		shapes = new ArrayList<Shape>();
	}
	
	public void launch(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) throws Exception {
		view.drawFrame(stage);
		view.drawCenter(shapes);
		view.setupButtons(factory, shapes);
	}
}
