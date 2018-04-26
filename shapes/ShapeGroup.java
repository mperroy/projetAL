package shapes;

import java.util.ArrayList;
import java.util.Iterator;

public class ShapeGroup implements ShapeInterface {

	private ArrayList<ShapeInterface> shapeMember;

	public ShapeGroup() {
		shapeMember = new ArrayList<ShapeInterface>();
	}

	@Override
	public void scale(int reductionRate) {
		for (ShapeInterface s : shapeMember)
			s.scale(reductionRate);
	}

	@Override
	public void rotate(double angle) {
		for (ShapeInterface s : shapeMember)
			s.rotate(angle);
	}

	@Override
	public void addShape(ShapeInterface u) {
		this.shapeMember.add(u);
	}

	@Override
	public void removeShape(ShapeInterface u) {
		this.shapeMember.remove(u);
	}

	@Override
	public Iterator<ShapeInterface> getChildren() {
		return shapeMember.iterator();
	}

	@Override
	public void translation(Coordinates newPosition) {
		for (ShapeInterface s : shapeMember)
			s.translation(newPosition);
	}

}
