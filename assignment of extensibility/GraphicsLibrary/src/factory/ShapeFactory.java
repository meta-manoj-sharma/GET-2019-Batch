package factory;

import java.util.*;

public class ShapeFactory {

	public static Shape createShape(Shape.ShapeType shapeType,
			Point originPoint, List<Integer> listOfparameter) {
		switch (shapeType) {
		case Circle:
			return new Circle(originPoint, listOfparameter);
		case Square:
			return new Square(originPoint, listOfparameter);
		case Rectangle:
			return new Rectangle(originPoint, listOfparameter);
		case Triangle:
			return new Triangle(originPoint, listOfparameter);
		case RegularPolygon:
			return new RegularPolygon(originPoint, listOfparameter);
		default:
			return null;
		}
	}
}
