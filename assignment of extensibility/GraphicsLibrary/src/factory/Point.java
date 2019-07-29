package factory;

public class Point {
	private final double xPoint;
	private final double yPoint;

	Point(double x, double y) {
		this.xPoint = x;
		this.yPoint = y;
	}

	double getXPoint() {
		return this.xPoint;
	}

	double getYPoint() {
		return this.yPoint;
	}
}
