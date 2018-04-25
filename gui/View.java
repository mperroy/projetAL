package gui;

import shapeFactory.ShapeAbstractFactory;

public interface View {
	// public void drawFrame(Stage stage);
	public void drawCommandBar();
	public void drawToolBar();
	public void setupButtons(ShapeAbstractFactory factory);
}