import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BaseBallGameManager {

	private static final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
	private BaseBallGameResultMaker baseBallGameResultMaker;

	public void initGame() {
		baseBallGameResultMaker = new BaseBallGameResultMaker(generateAnswer());
	}

	public ResultView makeGameResult(InputView inputView) {
		return baseBallGameResultMaker.returnGuessResult(inputView);
	}

	public Integer[] generateAnswer() {
		Random random = new Random(System.currentTimeMillis());
		Collections.shuffle(numbers, random);

		return new Integer[]{numbers.get(0), numbers.get(1), numbers.get(2)};
	}

}
