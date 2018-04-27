package gui;

import shapeFactory.ShapeAbstractFactory;
import shapes.ShapeToolbar;

public interface View {
	public void drawCommandBar();

	public void drawToolBar(ShapeToolbar toolbar);

	public void setupButtons(ShapeAbstractFactory factory);

}