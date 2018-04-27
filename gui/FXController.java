package gui;

import shapeFactory.*;
import shapes.Coordinates;
import shapes.MementoToolbar;
import shapes.RectangleSimple;
import shapes.RegularPolygonSimple;
import shapes.ShapeInterface;
import shapes.ShapeSimple;
import shapes.ShapeToolbar;

import java.util.Iterator;

import javafx.application.Application;
import javafx.stage.Stage;

public class FXController extends Application implements Controller {
	private ShapeAbstractFactory factory;
	private static ShapeToolbar toolbar; // test
	private static View view; // test

	public FXController() {
		factory = new FXFactory();
		toolbar = new ShapeToolbar();
		toolbar.add(new FXRectangle(new Coordinates(0, 0), 50, 25));
		toolbar.add(new FXRegularPolygon());

		MementoToolbar m = toolbar.createMemento();
		chargeToolbar(m);
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
	
	public void chargeToolbar(MementoToolbar m) {
		ShapeToolbar fxToolbar = new ShapeToolbar();
		
		toolbar.setMemento(m);
		Iterator<ShapeInterface> it = toolbar.getChildren();
		while (it.hasNext()) {
			ShapeSimple tmp = (ShapeSimple) it.next();
			if (tmp instanceof RectangleSimple)
				fxToolbar.add(new FXRectangle((RectangleSimple) tmp));
			if (tmp instanceof RegularPolygonSimple)
				fxToolbar.add(new FXRegularPolygon((RegularPolygonSimple) tmp));
		}
		
		toolbar = fxToolbar;
	}
}
