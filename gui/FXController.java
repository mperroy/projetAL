package gui;

import shapeFactory.*;

import javafx.application.Application;
import javafx.stage.Stage;

public class FXController extends Application implements Controller {
	private ShapeAbstractFactory factory;
	private View view;
	
	public FXController() {
		factory = new FXFactory();
		view = new FXView();
	}
	
	public void launchController(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) throws Exception {
		((FXView) view).drawFrame(stage);
		view.setupButtons(factory);
	}
}
