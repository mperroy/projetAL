package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import shapes.RectangleSimple;
import shapes.ShapeInterface;
import shapes.ShapeToolbar;

public class ShapeToolbarTest {

	ShapeToolbar st;
	ShapeInterface s;

	@Before
	public void setUp() throws Exception {
		st = new ShapeToolbar();
		s = new RectangleSimple();
	}

	@After
	public void tearDown() throws Exception {
		st = null;
		s = null;
	}

	@Test
	public void testAdd() {
		assertEquals(st.nbElement(), 0);
		st.add(s);
		assertEquals(st.nbElement(), 1);
	}

	@Test
	public void testRemove() {
		st.add(s);
		assertEquals(st.nbElement(), 1);
		st.remove(s);
		assertEquals(st.nbElement(), 0);
	}
}
