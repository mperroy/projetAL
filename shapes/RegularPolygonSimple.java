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
}
