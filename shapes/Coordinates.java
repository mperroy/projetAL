package shapes;

public class Coordinates {
	private double x;
	private double y;
	
	public Coordinates() {
		this.x = 0;
		this.y = 0;
	}
	
	public Coordinates(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double d) {
		this.x = d;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public Coordinates clone() {
		return new Coordinates(x, y);
	}
}
