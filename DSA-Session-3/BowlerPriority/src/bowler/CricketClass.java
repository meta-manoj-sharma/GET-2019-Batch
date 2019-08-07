package bowler;
import java.util.*;

public class CricketClass {
	static Queue<Bowler> queueOfBowler = new PriorityQueue<Bowler>(new ComparatorClass()); //Using priority queue so that the order is maintained in descending order as asked in question
/**
 * This method updates the each bowler's ball by decrementing 1
 * @param viratBall is the total number of balls to be faced by Virat Kohli
 * @return the String array containing order of bowler
 */
	public static String[] getBowled(int viratBall) {
		int index = 0;
		String array[] = new String[viratBall];
		while (viratBall != 0) {
			int updatedBalls = queueOfBowler.peek().balls - 1;//Fetching top bowler with maximum balls
			String bowlerName = queueOfBowler.peek().bowlerName;
			array[index++] = bowlerName;//Adding to array of string
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
		if (bowler1.balls < bowler2.balls)
			return 1;
		else if (bowler1.balls > bowler2.balls)
			return -1;
		return 0;
	}
	}