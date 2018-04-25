package gui;

import java.util.ArrayList;

import shapeFactory.ShapeAbstractFactory;
import shapes.Shape;

public interface View {
	// public void drawFrame(Stage stage);
	public void drawCommandBar();
	public void drawToolBar();
	public void drawCenter(ArrayList<Shape> shapes);
	public void setupButtons(ShapeAbstractFactory factory, ArrayList<Shape> shapes);
}
