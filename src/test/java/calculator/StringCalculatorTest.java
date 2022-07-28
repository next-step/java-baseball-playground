package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {
	private final StringCalculator calculator = new StringCalculator();

	@Test
	void add() {
		String actual = calculator.add(1, 2);
		assertThat(actual).isEqualTo("3");
	}

	@ParameterizedTest
	@CsvSource(
			value = {"1 + 2 : 3",
					"3 - 2 + 5 : 6",
					"4 - 3 - 5 + 3 * 2 / 5 + 1 : 1",
					"5 / 2 * 3 - 10 + 124 / 35 * 2 : 6"},
			delimiter = ':')
	void calculator(String userInput, int result) {
		String[] terms = calculator.getTerms(userInput);
		int actual = this.calculator.calculator(terms);
		assertThat(actual).isEqualTo(result);
	}

	@ParameterizedTest
	@CsvSource(
			value = {"1 + 2 : 3",
					"3 - 2 : 1",
					"3 * 2 : 6",
					"124 / 35 : 3"},
			delimiter = ':')
	void calculate(String equation, String result) {
		String[] terms = equation.split(" ");

		Stack<String> buffer = new Stack<>();
		buffer.push(terms[0]);
		buffer.push(terms[1]);
		buffer.push(terms[2]);

		String actual = calculator.calculate(buffer);
		assertThat(actual).isEqualTo(result);
	}

	@ParameterizedTest
	@CsvSource(value = {"1 : 0", "13213 : 0", "0 : 0"}, delimiter = ':')
	void divideByZero(int num1, int num2) {
		assertThatThrownBy(() -> calculator.divide(num1, num2))
				.isInstanceOf(ArithmeticException.class)
				.hasMessageContaining("can not divide by zero");
	}
}