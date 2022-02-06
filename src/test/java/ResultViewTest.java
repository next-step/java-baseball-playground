import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ResultViewTest {

	@Test
	@DisplayName("3 strike 시에는 correctAnswer값이 true다.")
	void test_3_strikes() {
		//given
		ResultView resultView = new ResultView(0, 3);

		//when
		boolean resultCorrectAnswer = resultView.isResultCorrectAnswer();

		//then
		assertTrue(resultCorrectAnswer);
	}

	@ParameterizedTest
	@CsvSource({
		"1,2",
		"2,1",
		"3,0"
	})
	@DisplayName("ball이 1개라도 있으면 correctAnswer값은 false다.")
	void test_include_ball_count(Integer ballCount, Integer strikeCount) {
		//given
		ResultView resultView = new ResultView(ballCount, strikeCount);

		//when
		boolean resultCorrectAnswer = resultView.isResultCorrectAnswer();

		//then
		assertFalse(resultCorrectAnswer);
	}
}