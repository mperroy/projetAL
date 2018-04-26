package gui;

import java.util.Iterator;

import shapeFactory.ShapeAbstractFactory;
import shapes.ShapeInterface;

public interface View {
	public void drawCommandBar();

	public void drawToolBar(Iterator<ShapeInterface> iterator);

	public void setupButtons(ShapeAbstractFactory factory);

	public void setupRightClick(ShapeInterface shape);
}