public class ResultView {
	private final Integer ball;
	private final Integer strike;

	public ResultView(Integer ball, Integer strike) {
		this.ball = ball;
		this.strike = strike;
	}

	public boolean isResultCorrectAnswer() {
		return this.ball.equals(0) && this.strike.equals(3);
	}

	public void printGameResult() {
		if (ball != 0) {
			System.out.print(ball+"볼 ");
		}

		if (strike != 0) {
			System.out.print(strike+"스트라이크");
		}
		System.out.println();
	}

	public Integer getBall() {
		return ball;
	}

	public Integer getStrike() {
		return strike;
	}

}