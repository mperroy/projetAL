package shapes;

public class RegularPolygonSimple extends ShapeSimple {
	private double edgeLength;
	private int edgeNumber;

	public RegularPolygonSimple() {
		super();
		this.edgeLength = 0;
		this.edgeNumber = 0;
	}

	public RegularPolygonSimple(Coordinates position, double edgeLength,
			int edgeNumber) {
		super(position);
		this.edgeLength = edgeLength;
		this.edgeNumber = edgeNumber;
	}
	
	public RegularPolygonSimple(RegularPolygonSimple poly) {
		super(poly);
		this.edgeLength = poly.getEdgeLength();
		this.edgeNumber = poly.getEdgeNumber();
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
