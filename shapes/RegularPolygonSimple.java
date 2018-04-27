package shapes;

public class RegularPolygonSimple extends ShapeSimple {
	private double edgeLength;
	private int edgeNumber;

	public RegularPolygonSimple() {
		super();
		this.edgeLength = 0;
		this.edgeNumber = 0;
	}

	public RegularPolygonSimple(Coordinates position, double edgeLength, int edgeNumber) {
		super(position);
		this.edgeLength = edgeLength;
		this.edgeNumber = edgeNumber;
	}

	public RegularPolygonSimple(RegularPolygonSimple poly) {
		super(poly);
		this.edgeLength = poly.getEdgeLength();
		this.edgeNumber = poly.getEdgeNumber();
	}

	public void setupVertix() {
		double x_center = getPosition().getX();
		double y_center = getPosition().getY();
		double x;
		double y;
		clear();

		for (int i = 0; i < getEdgeNumber(); i++) {
			x = getEdgeLength() * Math.cos(2 * Math.PI * i / getEdgeNumber() + 60) + x_center;
			y = getEdgeLength() * Math.sin(2 * Math.PI * i / getEdgeNumber() + 60) + y_center;

			addVertix(new Coordinates(x, y));
		}
	}

	private void clear() {
		while (!getVertices().isEmpty()) {
			getVertices().remove(0);
		}
	}
	
	
	public double getEdgeLength() {
		return edgeLength;
	}

	public void setEdgeLength(double edgeLength) {
		this.edgeLength = edgeLength;
	}

	public int getEdgeNumber() {
		return edgeNumber;
	}

	public void setEdgeNumber(int edgeNumber) {
		this.edgeNumber = edgeNumber;
	}

	public String toString() {
		StringBuffer str = new StringBuffer("RegularPolygon\n");
		str.append(edgeLength + " " + edgeNumber + "\n");
		str.append(super.toString());
		return str.toString();
	}
}
