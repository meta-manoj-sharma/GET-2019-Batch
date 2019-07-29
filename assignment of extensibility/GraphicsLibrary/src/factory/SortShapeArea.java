package factory;

import java.util.*;
// comparator to compare areas of two shapes 
public class SortShapeArea implements Comparator<Shape> {

	public int compare(Shape s1, Shape s2) {
		double area1 = s1.getArea();
		double area2 = s2.getArea();

		if (area1 > area2)
			return 1;
		else if (area1 < area2)
			return -1;
		return 0;
	}
}
//comparator to compare perimeter of two shapes 
class SortShapePerimeter implements Comparator<Shape> {

	public int compare(Shape s1, Shape s2) {
		double perimeter1 = s1.getPerimeter();
		double perimeter2 = s2.getPerimeter();

		if (perimeter1 > perimeter2)
			return 1;
		else if (perimeter1 < perimeter2)
			return -1;
		return 0;
	}
}
//comparator to compare origin distance of two shapes 
class SortShapeDistance implements Comparator<Shape> {

	public int compare(Shape s1, Shape s2) {
		double distance1 = s1.getOriginDistance();
		double distance2 = s2.getOriginDistance();

		if (distance1 > distance2)
			return 1;
		else if (distance1 < distance2)
			return -1;
		return 0;
	}
}
//comparator to compare timestamp of two shapes 
class SortShapeTimeStamp implements Comparator<Shape> {

	public int compare(Shape s1, Shape s2) {

		Date date1 = s1.getTimeStamp();
		Date date2 = s2.getTimeStamp();

		if (date1.after(date2))
			return -1;
		else if (date2.after(date1))
			return 1;
		return 0;
	}
}
