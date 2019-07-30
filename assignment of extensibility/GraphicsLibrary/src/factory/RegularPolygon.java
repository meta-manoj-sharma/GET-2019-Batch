package factory;

import java.util.*;

public class RegularPolygon implements Shape {

	private final double lengthOfside;
	private final double numberOfSide;
	Point origin;
	List<Point> listOfPolygonPoint;
	final Date timeStamp;

	/*
	 * parameterized constructor to initialize value
	 */
	public RegularPolygon(Point originPoint, List<Integer> parameter) {

		this.lengthOfside = parameter.get(0);
		this.numberOfSide = parameter.get(1);
		this.origin = originPoint;
		listOfPolygonPoint = new ArrayList<Point>();
		listOfPolygonPoint = calculatePoint();
		timeStamp = new Date();
	}

	/*
	 * method to get time of creating of Shape
	 * @return timeStamp
	 */
	@Override
	public Date getTimeStamp() {
		return timeStamp;
	}

	@Override
	public double getArea() {
		double area = (lengthOfside * lengthOfside) * (Math.sqrt(3) / 4);
		return area;
	}

	@Override
	public Point getOrigin() {

		return origin;
	}

	@Override
	public double getPerimeter() {

		return this.lengthOfside * this.numberOfSide;
	}

	@Override
	public ShapeType getShapeType() {

		return Shape.ShapeType.RegularPolygon;
	}

	/*
	 * method to get the boolean value true if point is inside the shape
	 * @return true if point is inside in shape
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		return false;
	}

	/*
	 * method to get distance between origin and the screen origin point
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

	public List<Point> getAllPoint() {
		return listOfPolygonPoint;
	}

	/*
	 * method to calculate the other point of the shape
	 * @return list of the point of the shape
	 */
	List<Point> calculatePoint() {
		listOfPolygonPoint.add(origin);
		double x = origin.getXPoint();
		double y = origin.getYPoint();
		double base = lengthOfside / 2;
		double angle = (180 - (360 / numberOfSide)) / 2;
		double radius = base / Math.cos(Math.toRadians(angle));
		double height = radius * Math.sin(Math.toRadians(angle));
		listOfPolygonPoint.add(new Point(x + base, y + height));
		return listOfPolygonPoint;
	}
}
