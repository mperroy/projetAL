package shapes;

import java.util.ArrayList;
import java.util.Iterator;

public class ShapeGroup implements Cloneable, ShapeInterface {

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

	@Override
	public double getMinX() {
		double res = shapeMember.get(0).getMinX();
		for(ShapeInterface s : shapeMember) {
			if(s.getMinX() < res)
				res = s.getMinX();
		}
		return res;
	}

	@Override
	public double getMaxX() {
		double res = shapeMember.get(0).getMaxX();
		for(ShapeInterface s : shapeMember) {
			if(s.getMaxX() > res)
				res = s.getMaxX();
		}
		return res;
	}

	@Override
	public double getMinY() {
		double res = shapeMember.get(0).getMinY();
		for(ShapeInterface s : shapeMember) {
			if(s.getMinY() < res)
				res = s.getMinY();
		}
		return res;
	}

	@Override
	public double getMaxY() {
		double res = shapeMember.get(0).getMaxY();
		for(ShapeInterface s : shapeMember) {
			if(s.getMaxY() > res)
				res = s.getMaxY();
		}
		return res;
	}

	@Override
	public ShapeInterface clone() {
		try {
			return (ShapeGroup) super.clone();
		}catch(CloneNotSupportedException e) {
			System.out.print("This is not the clone you are looking for");
			return null;
		}
	}
}
