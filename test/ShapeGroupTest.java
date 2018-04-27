package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import shapes.RectangleSimple;
import shapes.RegularPolygonSimple;
import shapes.ShapeGroup;
import shapes.ShapeInterface;

public class ShapeGroupTest {

	ShapeGroup sg;
	ShapeInterface s;
	ShapeInterface s2;

	@Before
	public void setUp() throws Exception {
		sg = new ShapeGroup();
		s = new RectangleSimple();
		s2 = new RegularPolygonSimple();
	}

	@After
	public void tearDown() throws Exception {
		sg = null;
		s = null;
		s2 = null;
	}

	@Test
	public void testAdd() {
		assertEquals(sg.nbElement(), 0);
		sg.addShape(s);
		assertEquals(sg.nbElement(), 1);
	}

	@Test
	public void testRemove() {
		sg.addShape(s);
		sg.addShape(s2);
		assertEquals(sg.nbElement(), 2);
		sg.removeShape(s);
		assertEquals(sg.nbElement(), 1);
	}
}
