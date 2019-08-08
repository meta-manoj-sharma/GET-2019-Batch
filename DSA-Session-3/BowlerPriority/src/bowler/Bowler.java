package bowler;

public class Bowler {
	private String bowlerName;
	private int balls;

	public Bowler(String bowlerName, int balls) {
		this.bowlerName = bowlerName;
		this.balls = balls;
	}

	// Getter methods
	public int getBallsOfBowler() {
		return balls;
	}

	public String getNameOfBowler() {
		return bowlerName;
	}

}
