import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {

	StringCalculator stringCalculator;

	@BeforeEach
	void init() {
		stringCalculator = new StringCalculator();
	}

	@ParameterizedTest
	@CsvSource({
		"2 + 3 * 4 / 2,10",
		"10 * 100 - 10 / 2,495",
		"9999 - 9999,0"
	})
	@DisplayName("정수 사칙 연산 테스트")
	public void test_default(String given, String expected) throws Throwable {
		String calculate = stringCalculator.calculate(given);
		assertEquals(expected, calculate);
	}


	@Nested
	class Validation_Test {
		@ParameterizedTest
		@CsvSource({"2.5, 5.123321312, 5 + 123, 2 + 3 * 4 / 2"})
		@DisplayName("사칙 연산자, 실수, 정수가 들어오면 valid exception이 발생하지 않는다.")
		public void test_validValue(String given) {
			Assertions.assertThatCode(() -> stringCalculator.calculate(given)).doesNotThrowAnyException();
		}

		@ParameterizedTest
		@ValueSource(strings = {"2a + 3 * 4 / 2", "aa", "bb", "한다빈"})
		@DisplayName("Invalid value가 들어오면 exception이 발생한다.")
		public void test_invalidValue(String given) {
			Assertions.assertThatThrownBy(() -> {
				stringCalculator.calculate(given);
			}).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Invalid value");
		}
	}

}