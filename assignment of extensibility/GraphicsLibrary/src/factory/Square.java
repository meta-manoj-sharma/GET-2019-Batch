package factory;

import java.util.*;

public class Square implements Shape {

	final private Point origin;
	final private double width;
	List<Point> listOfSquarePoint;
	final Date timeStamp;

	/*
	 * parameterized constructor to initialize value
	 */
	Square(Point origin, List<Integer> parameter) {
		this.origin = origin;
		this.width = parameter.get(0);
		listOfSquarePoint = new ArrayList<Point>();
		listOfSquarePoint = calculatePoint();
		timeStamp = new Date();
	}

	/*
	 * method to get time of creating of Shape
	 * 
	 * @return timeStamp
	 */
	@Override
	public Date getTimeStamp() {
		return timeStamp;
	}

	double getWidth() {
		return this.width;
	}

	@Override
	public double getArea() {

		return this.width * this.width;

	}

	@Override
	public Point getOrigin() {

		return origin;

	}

	@Override
	public double getPerimeter() {

		return 4 * this.width;

	}

	/*
	 * method to get distance between origin and the screen origin point
	 * 
	 * @return boolean value of distance
	 */
	@Override
	public double getOriginDistance() {
		double x1 = 0;
		double y1 = 0;
		double x2 = origin.getXPoint();
		double y2 = origin.getYPoint();
		double distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1)
				* (y2 - y1));

		return distance;
	}

	/*
	 * method to get the boolean value true if point is inside the shape
	 * 
	 * @return true if point is inside in shape
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		double x = point.getXPoint();
		double y = point.getYPoint();
		Point lastPoint = listOfSquarePoint.get(listOfSquarePoint.size() - 1);
		double xLast = lastPoint.getXPoint();
		double yLast = lastPoint.getYPoint();
		double xFirst = origin.getXPoint();
		double yFirst = origin.getYPoint();
		if (x >= xFirst && x <= xLast && y >= yFirst && y <= yLast)
			return true;
		return false;
	}

	public ShapeType getShapeType() {
		return Shape.ShapeType.Square;
	}

	List<Point> getAllPoint() {
		return listOfSquarePoint;
	}

	/*
	 * method to calculate the other point of the shape
	 * 
	 * @return list of the point of the shape
	 */
	private List<Point> calculatePoint() {
		listOfSquarePoint.add(origin);
		double x = origin.getXPoint();
		double y = origin.getYPoint();
		listOfSquarePoint.add(origin);
		listOfSquarePoint.add(new Point(x + width, y));
		listOfSquarePoint.add(new Point(x, y + width));
		listOfSquarePoint.add(new Point(x + width, y + width));

		return listOfSquarePoint;
	}
}
