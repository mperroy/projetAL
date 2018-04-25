package gui;

import shapeFactory.*;

public class Controller {
	private ShapeAbstractFactory factory;
	private View view;
	
	public Controller(boolean fx) {
		if(fx==true) {
			factory = new FXFactory();
			view = new FXView();
		}
		else {
			factory = new AWTFactory();
			view = new AWTView();
		}
	}
	
	public ShapeAbstractFactory getFactory() {
		return factory;
	}
	
	public View getView() {
		return view;
	}
}
