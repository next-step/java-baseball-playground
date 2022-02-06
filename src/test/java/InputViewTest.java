import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputViewTest {

	@ParameterizedTest
	@CsvSource({"123,1,2,3",
		"321,3,2,1",
		"231,2,3,1",
		"213,2,1,3",
	})
	@DisplayName("3자리 수를 3자리 digit으로 분리한다.")
	public void test(Integer input, Integer expectedDigit1, Integer expectedDigit2, Integer expectedDigit3) {
		//given
		InputView inputView = new InputView(input);

		//when
		Integer[] digits = inputView.getDigits();

		//then
		assertEquals(3, digits.length);
		assertEquals(expectedDigit1, digits[0]);
		assertEquals(expectedDigit2, digits[1]);
		assertEquals(expectedDigit3, digits[2]);
	}

}