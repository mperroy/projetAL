package shapes;

public class ColorSimple {
	int r;
	int g;
	int b;

	public ColorSimple() {
		this.r = 0;
		this.g = 0;
		this.b = 0;
	}

	public ColorSimple(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public void setColor(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(r + " " + g + " " + b);
		return str.toString();
	}
}
