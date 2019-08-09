package bowler;

import static org.junit.Assert.*;

import org.junit.Test;

public class CricketClassTest {
	@Test
	public void testGetBowlerOrder1() {
		// Asssuming sum of quota of each bowler is greater than ballByVirat
		int ballByVirat = 10;
		int noOfBowler = 5;
		String nameOfBowler[] = { "Irfan", "Malinga", "Bumrah", "Chahal", "Shami" };
		int ballsOfBowler[] = { 6, 5, 7, 8, 2 };
		for (int i = 0; i < nameOfBowler.length; i++) {
			CricketClass.queueOfBowler.add(new Bowler(nameOfBowler[i], ballsOfBowler[i]));
		}
		String arrayOfBowlers[] = CricketClass.getBowled(ballByVirat);
		String expectedArrayOfBowlers[] = { "Chahal", "Bumrah", "Chahal", "Bumrah", "Chahal", "Irfan", "Chahal", "Irfan", "Malinga","Bumrah" };
		assertArrayEquals(arrayOfBowlers, expectedArrayOfBowlers);
	}

	@Test
	public void testGetBowlerOrder2() {
		CricketClass.queueOfBowler.clear();
		int ballByVirat = 8;
		int noOfBowler = 3;
		String nameOfBowler[] = { "Malinga", "Bumrah", "Shami" };
		int ballsOfBowler[] = { 3, 2, 3 };
		for (int i = 0; i < nameOfBowler.length; i++) {
			CricketClass.queueOfBowler.add(new Bowler(nameOfBowler[i], ballsOfBowler[i]));
		}
		String arrayOfBowlers[] = CricketClass.getBowled(ballByVirat);
		String expectedArrayOfBowlers[] = { "Malinga", "Shami", "Malinga", "Shami", "Bumrah", "Shami", "Bumrah", "Malinga" };
		assertArrayEquals(arrayOfBowlers, expectedArrayOfBowlers);
	}
}
