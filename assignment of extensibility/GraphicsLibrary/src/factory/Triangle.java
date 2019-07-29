package factory;

import java.util.*;

public class Triangle implements Shape {
	final private double sideA;
	final private double sideB;
	final private double sideC;
	Point origin;
	List<Point> listOfTrianglePoint;
	final Date timeStamp;

	/*
	 * parameterized constructor to initialize value
	 */
	public Triangle(Point origin, List<Integer> parameter) {

		this.origin = origin;
		this.sideA = parameter.get(0);
		this.sideB = parameter.get(1);
		this.sideC = parameter.get(2);
		if(isCheckSide(this.sideA, this.sideB, this.sideC)){
		listOfTrianglePoint = new ArrayList<Point>();
		listOfTrianglePoint = calculatePoint();
		timeStamp = new Date();
		}
		else {
			throw new AssertionError("Invalid parameters of triangle. sum of two sides should be greater than third side");
			}
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

	public double getSideA() {
		return this.sideA;
	}

	public double getSideB() {
		return this.sideB;
	}

	public double getSideC() {
		return this.sideC;
	}

	@Override
	public double getArea() {

		double p = (this.sideA + this.sideB + this.sideC) / 2;

		return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));

	}

	@Override
	public Point getOrigin() {

		return origin;

	}

	@Override
	public double getPerimeter() {

		return this.sideA + this.sideB + this.sideC;

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
		double x1 = origin.getXPoint();
		double y1 = origin.getYPoint();
		Point secondPoint = listOfTrianglePoint.get(1);
		double x2 = secondPoint.getXPoint();
		double y2 = secondPoint.getYPoint();
		Point thirdPoint = listOfTrianglePoint.get(2);
		double x3 = thirdPoint.getXPoint();
		double y3 = thirdPoint.getYPoint();
		Double a1 = getAreaSubTriangle(x, y, x2, y2, x3, y3);
		double a2 = getAreaSubTriangle(x1, y1, x, y, x3, y3);
		double a3 = getAreaSubTriangle(x1, y1, x2, y2, x, y);
		if ((a1 + a2 + a3) == getArea())
			return true;
		return false;
	}

	@Override
	public ShapeType getShapeType() {
		return Shape.ShapeType.Triangle;
	}

	private double getAreaSubTriangle(double x1, double y1, double x2,
			double y2, double x3, double y3) {
		return ((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2);
	}

	public List<Point> getAllPoint() {
		return listOfTrianglePoint;
	}

	/*
	 * method to calculate the other point of the shape
	 * 
	 * @return list of the point of the shape
	 */
	List<Point> calculatePoint() {
		listOfTrianglePoint.add(origin);
		double x = origin.getXPoint();
		double y = origin.getYPoint();
		listOfTrianglePoint.add(new Point(x + sideA, y));
		double angle = Math
				.acos(((sideA * sideA) + (sideB * sideB) - (sideC * sideC))
						/ (2 * sideA * sideB));
		double height = sideB * Math.sin(angle);
		double base = sideB * Math.cos(angle);
		listOfTrianglePoint.add(new Point(x + sideA - base, y + height));
		double totalX = 0, totalY = 0;
		for (int index = 0; index < listOfTrianglePoint.size(); index++) {
			totalX += listOfTrianglePoint.get(index).getXPoint();
			totalY += listOfTrianglePoint.get(index).getYPoint();
		}
		listOfTrianglePoint.add(new Point(totalX / 3, totalY / 3));
		return listOfTrianglePoint;
	}
	public boolean isCheckSide(double sideA, double sideB, double sideC){
		double max[] ={sideA, sideB, sideC};
		Arrays.sort(max);
		if((max[0] + max[1]) > max[2])
			return true;
		else 
			return false;
}
}