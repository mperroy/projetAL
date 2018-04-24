package shapes;

public class Rectangle extends ShapeSimple {
	private int width;
	private int height;
	private double borderCurve;
	
	public Rectangle() {
		super();
		this.width = 6;
		this.height = 5;
		this.borderCurve = 0;
	}
	
	public Rectangle(Coordinates position, int width, int height) {
		super(position);
		this.width = width;
		this.height = height;
		this.borderCurve = 0;
		
		addVertix(getPosition().clone());
		addVertix(new Coordinates(getPosition().getX()+width, getPosition().getY()));
		addVertix(new Coordinates(getPosition().getX()+width, getPosition().getY()+height));
		addVertix(new Coordinates(getPosition().getX(), getPosition().getY()+height));
	}
	
	public void setBorderCurve(double borderCurve) {
		this.borderCurve = borderCurve;
	}
	
	// Width/Height -> Vertices OR Vertices -> Width/Height ?
}
