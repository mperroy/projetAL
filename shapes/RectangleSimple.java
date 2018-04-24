package shapes;

public class RectangleSimple extends ShapeSimple {
	private double width;
	private double height;
	private double borderCurve;
	
	public RectangleSimple() {
		super();
		this.width = 6;
		this.height = 5;
		this.borderCurve = 0;
	}
	
	public RectangleSimple(Coordinates position, int width, int height) {
		super(position);
		this.width = width;
		this.height = height;
		this.borderCurve = 0;
		
		addVertix(getPosition().clone());
		addVertix(new Coordinates(getPosition().getX()+width, getPosition().getY()));
		addVertix(new Coordinates(getPosition().getX()+width, getPosition().getY()+height));
		addVertix(new Coordinates(getPosition().getX(), getPosition().getY()+height));
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getBorderCurve() {
		return borderCurve;
	}
	
	public void setBorderCurve(double borderCurve) {
		this.borderCurve = borderCurve;
	}
	
	// Width/Height -> Vertices OR Vertices -> Width/Height ?
}
