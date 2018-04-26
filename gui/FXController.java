package gui;

import shapeFactory.*;
import shapes.ShapeToolbar;
import javafx.application.Application;
import javafx.stage.Stage;

public class FXController extends Application implements Controller {
	private ShapeAbstractFactory factory;
	private ShapeToolbar toolbar;
	private View view;

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
		view.drawToolBar(toolbar.getChildren());
		view.setupButtons(factory);
	}
}
