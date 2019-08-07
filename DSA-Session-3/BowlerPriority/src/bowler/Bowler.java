package bowler;

public class Bowler {
	String bowlerName;
	int balls;

	public Bowler(String bowlerName, int balls) {
		this.bowlerName = bowlerName;
		this.balls = balls;
	}
	//Getter methods 
	public int ballsOfBowler() {
		return balls;
	}

	public String nameOfBowler() {
		return bowlerName;
	}

}

