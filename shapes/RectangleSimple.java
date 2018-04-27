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

	public RectangleSimple(Coordinates position, double width, double height) {
		super(position);
		this.width = width;
		this.height = height;
		this.borderCurve = 0;

		addVertix(getPosition().clone());
		addVertix(new Coordinates(getPosition().getX() + width, getPosition().getY()));
		addVertix(new Coordinates(getPosition().getX() + width, getPosition().getY() + height));
		addVertix(new Coordinates(getPosition().getX(), getPosition().getY() + height));
	}
	
	public RectangleSimple(RectangleSimple rect) {
		super(rect);
		this.width = rect.getWidth();
		this.height = rect.getHeight();
		this.borderCurve = rect.getBorderCurve();
		
		setVertices(rect.getVertices());
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

	public String toString() {
		StringBuffer str = new StringBuffer("Rectangle\n");
		str.append(super.toString());
		str.append(width + " " + height + " " + borderCurve + "\n");
		return str.toString();
	}
}
