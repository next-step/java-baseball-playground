import java.util.ArrayList;
import java.util.List;

public class BaseBallGameResultMaker {

	//정답을 외부에서 주입 받아야 함 그래야 테스트가 됨
	private final Integer[] answerDigits;

	public BaseBallGameResultMaker(Integer[] answerDigits) {
		this.answerDigits = new Integer[]{answerDigits[0], answerDigits[1], answerDigits[2]};
	}

	public ResultView returnGuessResult(InputView inputView) {

		int idx = 0;
		int ball = 0;
		int strike = 0;

		for (Integer digit : inputView.getDigits()) {
			strike += calculateStrike(digit, idx);
			ball += calculateBall(digit, idx);
			idx++;
		}

		return new ResultView(ball, strike);
	}

	private Integer calculateStrike(Integer digit, int idx) {
		if (digit.equals(answerDigits[idx])) {
			return 1;
		}

		return 0;
	}

	private Integer calculateBall(Integer digit, int idx) {
		List<Integer> ballIdxList = new ArrayList<>();

		if (idx == 0) {
			ballIdxList.add(1);
			ballIdxList.add(2);
		}

		if (idx == 1) {
			ballIdxList.add(0);
			ballIdxList.add(2);
		}

		if (idx == 2) {
			ballIdxList.add(0);
			ballIdxList.add(1);
		}

		if (answerDigits[ballIdxList.get(0)].equals(digit)) {
			return 1;
		}

		if (answerDigits[ballIdxList.get(1)].equals(digit)) {
			return 1;
		}

		return 0;
	}
}