package bowler;

import java.util.*;
	/**
	 * this program give the order of bowler so that virat can score minimum
	 * @author Manoj Sharma
	 * Dated 2 august 2019
	 */
public class CricketClass {
	// Using priority queue so that the order is maintained in descending order
	static Queue<Bowler> queueOfBowler = new PriorityQueue<Bowler>(new ComparatorClass());

	/**
	 * This method updates the each bowler's ball by decrementing 1
	 * @param viratBall is the total number of balls to be faced by Virat Kohli
	 * @return the String array containing order of bowler
	 */
	public static String[] getBowled(int viratBall) {
		int index = 0;
		String array[] = new String[viratBall];
		while (viratBall != 0) {
			// Fetching top bowler with maximum balls
			int updatedBalls = queueOfBowler.peek().getBallsOfBowler() - 1;
			String bowlerName = queueOfBowler.peek().getNameOfBowler();
			// Adding to array of string
			array[index++] = bowlerName;
			queueOfBowler.remove();
			if (updatedBalls != 0) {
				queueOfBowler.add(new Bowler(bowlerName, updatedBalls));
			}
			viratBall--;
		}
		return array;
	}
}

class ComparatorClass implements Comparator<Bowler> {
	public int compare(Bowler bowler1, Bowler bowler2) {
		if (bowler1.getBallsOfBowler() < bowler2.getBallsOfBowler())
			return 1;
		else if (bowler1.getBallsOfBowler() > bowler2.getBallsOfBowler())
			return -1;
		return 0;
	}
}