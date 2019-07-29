package factory;

import java.util.*;

public class Screen {
	List<Shape> listOfShape;
	final int XMAX;
	final int YMAX;

	/*
	 * parameterized constructor to initialize limit of the screen
	 */
	Screen(int x, int y) {
		listOfShape = new ArrayList<Shape>();
		XMAX = x;
		YMAX = y;
	}

	/**
	 * private method to check that a point is inside or outside the screen
	 * @return true id point inside the screen
	 */
	private boolean isValidPoint(Point point) {
		if (point.getXPoint() < XMAX && point.getYPoint() < YMAX) {
			return true;
		}
		return false;
	}

	/**
	 * method to add a shape to shape list
	 * @return true is shape is successfully added to the screen
	 */
	boolean addShape(Shape.ShapeType shape, Point originPoint,
			List<Integer> parameterList) {
		if (isValidPoint(originPoint)) {
			Shape typeOfShape = ShapeFactory.createShape(shape, originPoint,
					parameterList);
			listOfShape.add(typeOfShape);
			return true;
		}
		return false;
	}

	/**
	 * method to delete a shape from the list according to origin point
	 * @return true id shape is deleted successfully
	 */
	boolean deleteShape(Shape.ShapeType shape, Point originPoint) {
		if (isValidPoint(originPoint)) {
			Shape shapefound = findShape(shape, originPoint);
			if (shapefound == null)
				return false;
			listOfShape.remove(shapefound);
			return true;

		}
		return false;
	}

	/**
	 * method to delete all shape of same type
	 * @return true id all shape deleted
	 */
	boolean deleteAllShape(Shape.ShapeType shape) {
		boolean flag = false;
		for (int index = 0; index < listOfShape.size(); index++) {
			Shape sh = listOfShape.get(index);
			if (sh.getShapeType() == shape) {
				listOfShape.remove(sh);
				index = index - 1;
				flag = true;
			}

		}
		return flag;
	}

	/**
	 * method to sort the shape object according to input choice
	 * @param choice is a string as choice
	 * @return sorted list according to choice
	 */
	public List<Shape> sortShape(String choice) {

		switch (choice) {
		case "area":
			Collections.sort(listOfShape, new SortShapeArea());
			System.out.println("here" + listOfShape);
			return listOfShape;
		case "perimeter":
			Collections.sort(listOfShape, new SortShapePerimeter());
			return listOfShape;
		case "distance":
			Collections.sort(listOfShape, new SortShapeDistance());
			return listOfShape;
		case "time":
			Collections.sort(listOfShape, new SortShapeTimeStamp());
			return listOfShape;
		default:
			return null;
		}

	}

	/**
	 * method to return all the shape which are enclosing a point
	 * @para point
	 * @return all the shape that enclose this point
	 */
	public List<Shape> enclosingShape(Point point) {
		if (isValidPoint(point)) {
			List<Shape> enclosingPointShapeList = new ArrayList<Shape>();
			for (int index = 0; index < listOfShape.size(); index++) {
				Shape s = listOfShape.get(index);
				if (s.isPointEnclosed(point))
					enclosingPointShapeList.add(s);

			}
			return enclosingPointShapeList;
		}
		return null;

	}

	/*
	 * private mehtod to find a shape from all shape with given origin and type
	 * of shape
	 * 
	 * @param origin point
	 * 
	 * @param shape as type of shape
	 * 
	 * @return shape
	 */
	private Shape findShape(Shape.ShapeType shape, Point originPoint) {
		for (int index = 0; index < listOfShape.size(); index++) {
			Shape s = listOfShape.get(index);
			Point origin = s.getOrigin();
			double x = origin.getXPoint();
			double y = origin.getYPoint();
			if (s.getShapeType() == shape && originPoint.getXPoint() == x
					&& originPoint.getYPoint() == y) {
				return s;
			}
		}
		return null;
	}

	public boolean display() {
		if (listOfShape.size() != 0) {
			System.out
					.println("Last element of the list will be displayed on front of screen");
			for (int indexFirst = 0; indexFirst < listOfShape.size(); indexFirst++) {
				System.out.println((indexFirst + 1) + "\t"
						+ listOfShape.get(indexFirst).getShapeType()
						+ "\t Area- " + listOfShape.get(indexFirst).getArea()
						+ "\t Perimeter- "
						+ listOfShape.get(indexFirst).getPerimeter()
						+ "\t OriginDistance- "
						+ listOfShape.get(indexFirst).getOriginDistance()
						+ "\t Time- "
						+ listOfShape.get(indexFirst).getTimeStamp()
						+ "\t Point- ("
						+ listOfShape.get(indexFirst).getOrigin().getXPoint()
						+ ","
						+ listOfShape.get(indexFirst).getOrigin().getYPoint()
						+ ")");
			}
			return true;
		} else {
			System.out.println("Screen Empty");
			return false;
		}
	}
}
