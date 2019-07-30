package factory;

import java.util.*;

public interface Shape {

	double getArea();

	Point getOrigin();

	double getPerimeter();

	boolean isPointEnclosed(Point point);

	double getOriginDistance();

	Date getTimeStamp();

	enum ShapeType {
		Square, Rectangle, Circle, Triangle, RegularPolygon;
	}
		public List<Point> getAllPoint(); 
		
	ShapeType getShapeType();
}
