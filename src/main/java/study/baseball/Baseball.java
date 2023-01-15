package study.baseball;

public class Baseball {

	private int strike;
	private int ball;
	
	public Baseball() {
		
	}
	
	public Baseball(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public int getStrike() {
		return strike;
	}
	
	public int getBall() {
		return ball;
	}
}
