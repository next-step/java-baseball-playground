import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseBallGameResultMakerTest {

	BaseBallGameResultMaker baseBallGameResultMaker;

	@DisplayName("InputValue에 따라 ball과 strike 갯수를 계산하여 ResultView를 생성한다.")
	@ParameterizedTest
	@CsvSource(
		{"123,134,1,1",
		"397,785,1,0",
		"764,123,0,0",
		"392,152,0,1",
		"928,928,0,3",
		"432,243,3,0",}
	)
	void test1(Integer answerValue, Integer inputValue, Integer ballCount, Integer strikeCount) {
		//given
		baseBallGameResultMaker = new BaseBallGameResultMaker(generateDigits(answerValue));

		//when
		InputView inputView = new InputView(inputValue);
		ResultView actual = baseBallGameResultMaker.returnGuessResult(inputView);

		//then
		assertEquals(ballCount, actual.getBall());
		assertEquals(strikeCount, actual.getStrike());
	}

	private Integer[] generateDigits(Integer value) {
		return new Integer[]{(value / 100), (value % 100 / 10), (value % 100 % 10)};
	}
}