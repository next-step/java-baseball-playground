package study;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorBasicTest {

	CalculatorBasic cal;

	@BeforeEach
	void setUp() {
		cal = new CalculatorBasic();
	}

	@Test
	void Start() {

	}

	@ParameterizedTest
	@ValueSource(strings = "1 + 2 / 3 - 4") // go to Parameter
	void split(String nums) {

		String[] actual = cal.split(nums);
		String[] expected = {"1", "+", "2", "/", "3", "-", "4"};

		assertArrayEquals(expected, actual);
	}

	@ParameterizedTest
	@CsvSource(value = {"+:true", "-:true", "test:false", "test2:false", "*:true"}, delimiter = ':')
	void isOperator(String operator, String expected) {
		String isOperator = cal.isOperator(operator) ? "true" : "false";
		assertEquals(expected, isOperator);
	}

	@Test
	void operating() {
		// GIVEN
		cal.answer = 3;

		// WHEN
		cal.operator = "+";
		cal.operating("3");
		assertEquals(6, cal.answer);

		cal.operator = "-";
		cal.operating("2");
		assertEquals(4, cal.answer);

		cal.operator = "/";
		cal.operating("2");
		assertEquals(2, cal.answer);

		cal.operator = "*";
		cal.operating("5");
		assertEquals(10, cal.answer);
	}

}
