package bowler;

public class Main {
	public static void main(String[] args) {
		int ballByVirat = 10;
		int noOfBowler = 5;
		String nameOfBowler[] = { "Irfan", "Malinga", "Bumrah", "Chahal", "Shami" };
		int ballsOfBowler[] = { 6, 5, 7, 8, 2 };
		for (int i = 0; i < nameOfBowler.length; i++) {
			CricketClass.queueOfBowler.add(new Bowler(nameOfBowler[i], ballsOfBowler[i]));
		}
		String check[] = CricketClass.getBowled(ballByVirat);
		System.out.println("ORDER of Bowler ");
		for (int k = 0; k < check.length; k++) {
			System.out.println(check[k]);
		}
		System.out.println("Remaining quota of Bowler Summary");
		while (!CricketClass.queueOfBowler.isEmpty()) {
			System.out.println("Name " + CricketClass.queueOfBowler.peek().getNameOfBowler() + " Balls = "
					                   + CricketClass.queueOfBowler.peek().getNameOfBowler());
			CricketClass.queueOfBowler.remove();
		}
	}
}
