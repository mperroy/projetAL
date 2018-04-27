package gui;

import shapeFactory.*;
import shapes.ShapeInterface;
import shapes.ShapeToolbar;
import javafx.application.Application;
import javafx.stage.Stage;

public class FXController extends Application implements Controller {
	private ShapeAbstractFactory factory;
	private static ShapeToolbar toolbar; // test
	private static View view; // test

	public FXController() {
		factory = new FXFactory();
		toolbar = new ShapeToolbar();
		toolbar.add(new FXRectangle());
		toolbar.add(new FXRegularPolygon());

		view = new FXView();
	}

	public void launchController(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		((FXView) view).drawFrame(stage);
		view.drawToolBar(toolbar);
		view.setupButtons(factory);
	}
	
	// Test ajout toolbar
	public static void addToToolbar(ShapeInterface s) {
		if(toolbar!=null) {
			toolbar.add(s);
			view.drawToolBar(toolbar);
		}
	}
}
