package factory;

import java.util.*;

public class Main {
	/*
	 * @param shape type List 
	 * @return boolean true if screen is displayed
	 * @return boolean false if screen is not displayed
	 */
	public static boolean display(List<Shape> sorted) {
		if (sorted.size() != 0) {
			System.out
					.println("Last element of the list will be displayed on front of screen");
			for (int indexFirst = 0; indexFirst < sorted.size(); indexFirst++) {
				System.out.println((indexFirst + 1) + "\t"
						+ sorted.get(indexFirst).getShapeType() + "\t Area- "
						+ sorted.get(indexFirst).getArea() + "\tPerimeter- "
						+ sorted.get(indexFirst).getPerimeter()
						+ "\t OriginDistance- "
						+ sorted.get(indexFirst).getOriginDistance()
						+ "\t Time-" + sorted.get(indexFirst).getTimeStamp()
						+ "\t Point- ("
						+ sorted.get(indexFirst).getOrigin().getXPoint() + ","
						+ sorted.get(indexFirst).getOrigin().getYPoint() + ")");
			}
			return true;
		} else {
			System.out.println("Screen Empty");
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Screen screen = new Screen(100, 100);
		try {
			// runs until user terminates
			while (true) {
				System.out.println("Enter 1 for Adding a shape to screen");
				System.out
						.println("Enter 2 for Deleting a Shape from Screen's Front");
				System.out
						.println("Enter 3 for Deleting All Shapes of a particular type from Screen");
				System.out.println("Enter 4 for displaying shapes on Screen");
				System.out.println("Enter 5 for Sorting Shapes");
				System.out
						.println("Enter 6 for checking a point encloses how many shapes");
				System.out.println("Enter 7 for Exit");
				int userInput = in.nextInt();
				switch (userInput) {
				case 1:
					int choice = inputShape(in);
					if (choice < 1 || choice > 4) {
						System.out.println("Invalid Shape Selection");
					} else {
						System.out.println("Choice Inputted Succesfully");
						System.out
								.println("Enter nearest Point of Shape with Origin ");
						ArrayList<Integer> list = new ArrayList<Integer>();
						System.out.println("Enter X cordinate of Point");
						double x = in.nextDouble();
						System.out.println("Enter y cordinate of Point");
						double y = in.nextDouble();
						Point point = new Point(x, y);
						if (choice == 1) {
							System.out.println("Enter Length of Rectangle");
							list.add(in.nextInt());
							System.out.println("Enter Breadth of Rectangle");
							list.add(in.nextInt());
							screen.addShape(Shape.ShapeType.Rectangle, point,
									list);
						} else if (choice == 2) {
							System.out.println("Enter Side of Square");
							list.add(in.nextInt());
							screen.addShape(Shape.ShapeType.Square, point, list);
						} else if (choice == 3) {
							System.out.println("Enter side A of Triangle");
							list.add(in.nextInt());
							System.out.println("Enter side B of Triangle ");
							list.add(in.nextInt());
							System.out.println("Enter side c of Triangle");
							list.add(in.nextInt());
							screen.addShape(Shape.ShapeType.Triangle, point,
									list);
						} else if (choice == 4) {
							System.out.println("Enter radius of Circle");
							list.add(in.nextInt());
							screen.addShape(Shape.ShapeType.Circle, point, list);
						}
					}
					break;
				case 2:
					System.out.println("Displaying Screen");
					if (screen.display()) {
						System.out
								.println("Elements will be deleted from Front of Screen First");
						int choiceOfUser = inputShape(in);
						System.out.println("Enter origin of shape");
						System.out.println("Enter X cordinate of origin");
						double x = in.nextDouble();
						System.out.println("Enter y cordinate of origin");
						double y = in.nextDouble();
						Point origin = new Point(x, y);
						Shape.ShapeType shape = null;
						if (true) {
							if (choiceOfUser == 1) {
								shape = Shape.ShapeType.Rectangle;
							} else if (choiceOfUser == 2) {
								shape = Shape.ShapeType.Square;
							} else if (choiceOfUser == 3) {
								shape = Shape.ShapeType.Triangle;
							} else if (choiceOfUser == 4) {
								shape = Shape.ShapeType.Circle;
							}
						}
						if (shape == null) {
							System.out.println("Shape Not in Library");
						}
						if (screen.deleteShape(shape, origin)) {
							System.out
									.println("All Occurences of Shape Deleted");
						} else {
							System.out.println("Shape Not Found on Screen");
						}
					}
					break;
				case 3:
					System.out.println("Displaying Screen");
					if (screen.display()) {
						System.out
								.println("All Elements of a Particular type will be deleted from Screen");
						int choiceOfUser = inputShape(in);
						Shape.ShapeType shape = null;
						if (true) {
							if (choiceOfUser == 1) {
								shape = Shape.ShapeType.Rectangle;
							} else if (choiceOfUser == 2) {
								shape = Shape.ShapeType.Square;
							} else if (choiceOfUser == 3) {
								shape = Shape.ShapeType.Triangle;
							} else if (choiceOfUser == 4) {
								shape = Shape.ShapeType.Circle;
							}
						}
						if (shape == null) {
							System.out.println("Shape Not in Library");
						}
						if (screen.deleteAllShape(shape)) {
							System.out
									.println("All Occurences of Shape Deleted");
						} else {
							System.out.println("Shape Not Found on Screen");
						}
					}
					break;
				case 4:
					screen.display();
					break;
				case 5:
					System.out.println("S.No.\t\tSorting Style");
					System.out.println("1.\t\tArea");
					System.out.println("2.\t\tPerimeter");
					System.out.println("3.\t\tOrigin");
					System.out.println("4.\t\tTimestamp");
					System.out.println("Enter the s.no of of sorting style");
					int style = in.nextInt();
					List<Shape> sorted = null;
					if (style == 1) {
						sorted = screen.sortShape("area");
						if (display(sorted)) {
							System.out.println();
						} else {
							System.out.println("Issue Traced");
						}
					} else if (style == 2) {
						sorted = screen.sortShape("perimeter");
						if (display(sorted)) {
							System.out.println();
						} else {
							System.out.println("Issue Traced");
						}
					} else if (style == 3) {
						sorted = screen.sortShape("distance");
						if (display(sorted)) {
							System.out.println();
						} else {
							System.out.println("Issue Traced");
						}
					} else if (style == 4) {
						sorted = screen.sortShape("timestamp");
						if (display(sorted)) {
							System.out.println();
						} else {
							System.out.println("Issue Traced");
						}
					}
					break;
				case 6:
					System.out
							.println("Enter coordinates of Point to be checked");
					System.out.println("Enter X Coordinate");
					double xCoordinate = in.nextDouble();
					System.out.println("Enter Y Coordinate");
					double yCoordinate = in.nextDouble();
					Point point = new Point(xCoordinate, yCoordinate);
					if (!display(screen.enclosingShape(point))) {
						System.out.println("No Shape Encloses Your Point");
					}
					break;
				case 7:
					System.out.println("SCREEN OPERATIONS ABORTED!!!");
					System.exit(0);

				}
			}
		}
		// Exception Handling
		catch (Exception e) {
			System.out.println("Invalid Input");
			main(args);
		}
	}

	/*
	 * @param Scanner object
	 * @return int type user input
	 */
	public static int inputShape(Scanner in) {
		System.out.println("Select Shape from Shapes Given below");
		System.out.println("S.No.\t\tShape");
		System.out.println("1\t\tRectangle");
		System.out.println("2\t\tSquare");
		System.out.println("3\t\tTriangle");
		System.out.println("4\t\tCircle");
		System.out.println("Enter your choice according to serial numbers");
		int choice = in.nextInt();
		return choice;
	}
}
