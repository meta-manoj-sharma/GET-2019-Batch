package factory;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class ScreenTest {

	/*
	 * positive test case for add a shape in shape list
	 */
	@Test
	public void addShapeTestPositive() {
		Screen s = new Screen(100, 100);
		List<Integer> para = new ArrayList<Integer>();
		para.add(4);
		Point p = new Point(3, 5);
		assertTrue(s.addShape(Shape.ShapeType.Circle, p, para));
		Shape shape = s.listOfShape.get(s.listOfShape.size() - 1);
		Point origin = shape.getOrigin();
		assertEquals(50.24, shape.getArea(), 0.002);
		assertEquals(25.12, shape.getPerimeter(), 0.002);
		assertEquals(Shape.ShapeType.Circle, shape.getShapeType());
		assertEquals(3, origin.getXPoint(), 0.0002);
		assertEquals(5, origin.getYPoint(), 0.002);
	}

	/*
	 * Negative test case for adding a shape in screen
	 */
	@Test
	public void addShapeTestNegative() {
		Screen s = new Screen(100, 100);
		List<Integer> para = new ArrayList<Integer>();
		para.add(4);
		Point p = new Point(110, 50);
		assertFalse(s.addShape(Shape.ShapeType.Circle, p, para));
	}

	/*
	 * positive test case for delete a shape in shapelist
	 */
	@Test
	public void deleteShapeTestPositive() {
		Screen s = new Screen(100, 100);
		List<Integer> para = new ArrayList<Integer>();
		para.add(4);
		para.add(6);
		Point p = new Point(3, 5);
		assertTrue(s.addShape(Shape.ShapeType.Rectangle, p, para));
		Shape shape = s.listOfShape.get(s.listOfShape.size() - 1);
		Point origin = shape.getOrigin();
		assertEquals(24, shape.getArea(), 0.002);
		assertEquals(20, shape.getPerimeter(), 0.002);
		assertEquals(Shape.ShapeType.Rectangle, shape.getShapeType());
		assertEquals(3, origin.getXPoint(), 0.0002);
		assertEquals(5, origin.getYPoint(), 0.002);

		assertTrue(s.deleteShape(Shape.ShapeType.Rectangle, p));
		assertEquals(0, s.listOfShape.size());
	}
	
	/*
	 * positive test case for deleteAll shape of same type in shapelist
	 */
	@Test
	public void deleteAllShapeTestPositive() {
		Screen s = new Screen(100, 100);
		List<Integer> para = new ArrayList<Integer>();
		para.add(4);
		para.add(6);
		Point p = new Point(3, 5);
		assertTrue(s.addShape(Shape.ShapeType.Rectangle, p, para));
		assertTrue(s.addShape(Shape.ShapeType.Rectangle, p, para));
		assertTrue(s.addShape(Shape.ShapeType.Square, p, para));

		assertEquals(3, s.listOfShape.size());
		assertTrue(s.deleteAllShape(Shape.ShapeType.Rectangle));
		assertEquals(1, s.listOfShape.size());
	}

	/*
	 * Negative test case for deleting all the shape of same type in screen
	 */
	@Test
	public void deleteAllShapeTestNegative() {
		Screen s = new Screen(100, 100);
		List<Integer> para = new ArrayList<Integer>();
		para.add(4);
		para.add(6);
		Point p = new Point(3, 5);
		assertTrue(s.addShape(Shape.ShapeType.Rectangle, p, para));
		assertTrue(s.addShape(Shape.ShapeType.Rectangle, p, para));
		assertTrue(s.addShape(Shape.ShapeType.Square, p, para));

		assertEquals(3, s.listOfShape.size());
		assertFalse(s.deleteAllShape(Shape.ShapeType.Circle));
		assertEquals(3, s.listOfShape.size());
	}

	/*
	 * positive test case for find all the shape in shapelist that enclosing a
	 * point
	 */
	@Test
	public void enclosingShapeTestPositive() {
		Screen s = new Screen(100, 100);
		List<Integer> para = new ArrayList<Integer>();
		para.add(4);
		Point p = new Point(3, 5);
		assertTrue(s.addShape(Shape.ShapeType.Circle, p, para));
		Shape shape = s.listOfShape.get(s.listOfShape.size() - 1);
		Point origin = shape.getOrigin();
		assertEquals(50.24, shape.getArea(), 0.002);
		assertEquals(25.12, shape.getPerimeter(), 0.002);
		assertEquals(Shape.ShapeType.Circle, shape.getShapeType());
		assertEquals(3, origin.getXPoint(), 0.0002);
		assertEquals(5, origin.getYPoint(), 0.002);

		para.add(5);
		para.add(3);
		assertTrue(s.addShape(Shape.ShapeType.Triangle, p, para));
		shape = s.listOfShape.get(s.listOfShape.size() - 1);
		origin = shape.getOrigin();
		assertEquals(6, shape.getArea(), 0.002);
		assertEquals(12, shape.getPerimeter(), 0.002);
		assertEquals(Shape.ShapeType.Triangle, shape.getShapeType());
		assertEquals(3, origin.getXPoint(), 0.0002);
		assertEquals(5, origin.getYPoint(), 0.002);

		List<Shape> listEnclosing = new ArrayList<Shape>();
		listEnclosing = s.enclosingShape(new Point(4, 4));
		System.err.println(listEnclosing.size());
		assertEquals(1, listEnclosing.size());
	}

	/*
	 * positive test case for sorting the shape in shapelist
	 */
	@Test
	public void sortShapeTestPositive() {
		Screen s = new Screen(100, 100);
		List<Integer> para = new ArrayList<Integer>();
		para.add(4);
		para.add(5);
		Point p = new Point(3, 5);
		assertTrue(s.addShape(Shape.ShapeType.RegularPolygon, p, para));
		Shape shape = s.listOfShape.get(s.listOfShape.size() - 1);
		Point origin = shape.getOrigin();
		assertEquals(6.9282, shape.getArea(), 0.002);
		assertEquals(20, shape.getPerimeter(), 0.002);
		assertEquals(Shape.ShapeType.RegularPolygon, shape.getShapeType());
		assertEquals(3, origin.getXPoint(), 0.0002);
		assertEquals(5, origin.getYPoint(), 0.002);

		para.add(3);
		assertTrue(s.addShape(Shape.ShapeType.Triangle, p, para));
		shape = s.listOfShape.get(s.listOfShape.size() - 1);
		origin = shape.getOrigin();
		assertEquals(6, shape.getArea(), 0.002);
		assertEquals(12, shape.getPerimeter(), 0.002);
		assertEquals(Shape.ShapeType.Triangle, shape.getShapeType());
		assertEquals(3, origin.getXPoint(), 0.0002);
		assertEquals(5, origin.getYPoint(), 0.002);

		s.sortShape("area");
		Shape s1 = s.listOfShape.get(0);
		Shape s2 = s.listOfShape.get(1);

		assertEquals(Shape.ShapeType.Triangle, s1.getShapeType());
		assertEquals(Shape.ShapeType.RegularPolygon, s2.getShapeType());
	}
}
