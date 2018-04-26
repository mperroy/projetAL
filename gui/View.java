package gui;

import java.util.Iterator;

import shapeFactory.ShapeAbstractFactory;
import shapes.Shape;

public interface View {
	// public void drawFrame(Stage stage);
	public void drawCommandBar();
	public void drawToolBar(Iterator<Shape> iterator);
	public void setupButtons(ShapeAbstractFactory factory);
}