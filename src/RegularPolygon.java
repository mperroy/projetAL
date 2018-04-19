package src;

public class RegularPolygon extends ShapeSimple{
	private double edgeLength;
	private int edgeNumber;
	
	public RegularPolygon() {
		super();
		this.edgeLength = 0;
		this.edgeNumber = 0;
	}
	
	public RegularPolygon(Coordinates position, double edgeLength, int edgeNumber) {
		super(position);
		this.edgeLength = edgeLength;
		this.edgeNumber = edgeNumber;
		
		// Vertices position ?
	}
}
