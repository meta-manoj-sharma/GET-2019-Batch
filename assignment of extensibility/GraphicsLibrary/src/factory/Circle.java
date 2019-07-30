package factory;

import java.util.*;

public class Circle implements Shape {

	private double radius;
	final double PI = 3.14;
	Point origin;
	List<Point> listOfCirclePoint;
	final Date timeStamp;

	/*
	 * parameterized constructor to initialize value
	 */
	Circle(Point origin, List<Integer> parameter) {
		this.origin = origin;
		this.radius = parameter.get(0);
		listOfCirclePoint = new ArrayList<Point>();
		listOfCirclePoint = calculatePoint();
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

	double getRadius() {
		return this.radius;
	}

	@Override
	public double getArea() {

		return PI * this.radius * this.radius;

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

	@Override
	public Point getOrigin() {

		return origin;

	}

	@Override
	public double getPerimeter() {

		return 2 * PI * this.radius;

	}

	/*
	 * method to get the boolean value true if point is inside the shape
	 * 
	 * @return true if point is inside in shape
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		double x1 = origin.getXPoint();
		double y1 = origin.getYPoint();
		double x2 = point.getXPoint();
		double y2 = point.getYPoint();
		double distance = Math.sqrt((x2 - x1) + (y2 - y1));
		if (distance <= radius)
			return true;
		return false;
	}

	@Override
	public ShapeType getShapeType() {

		return Shape.ShapeType.Circle;

	}

	public List<Point> getAllPoint() {
		return listOfCirclePoint;
	}

	/*
	 * method to calculate the other point of the shape
	 * @return list of the point of the shape
	 */
	List<Point> calculatePoint() {
		listOfCirclePoint.add(origin);
		double x = origin.getXPoint();
		double y = origin.getYPoint();
		double slope = y / x;
		double angle = Math.atan(slope);
		double height = this.radius * Math.sin(angle);
		double base = this.radius * Math.cos(angle);
		listOfCirclePoint.add(new Point(x + base, y + height));
		listOfCirclePoint.add(new Point(x - base, y - height));
		return listOfCirclePoint;
	}
	
}
