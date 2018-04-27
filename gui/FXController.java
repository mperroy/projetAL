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
	private static ShapeToolbar toolbar;
	private static View view;
	private MementoToolbar m;

	public FXController() {
		factory = new FXFactory();
		m = new MementoToolbar();
		
		toolbar = new ShapeToolbar();
		chargeToolbar(m);
		
		if(!toolbar.getChildren().hasNext()) {
			toolbar.add(new FXRectangle(new Coordinates(0, 0), 50, 25));
			toolbar.add(new FXRegularPolygon());

			m = toolbar.createMemento();
		}
		
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
	
	public static void addToToolbar(ShapeInterface s) {
		if(toolbar != null) {
			toolbar.add(s);
			view.drawToolBar(toolbar);
			toolbar.createMemento();
		}
	}
	
	public static void removeFromToolbar(ShapeInterface s) {
		if(toolbar != null) {
			toolbar.remove(s);
			toolbar.createMemento();
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
