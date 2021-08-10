package study;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

	Calculator cal;

	@BeforeAll
	void setUp() {
		cal = new Calculator();
	}

	@Test
	void start() {
		String fomular = cal.scanner.nextLine();
	}

	@ParameterizedTest
	@ValueSource(strings = "1 + 2 / 3 - 4") // go to Parameter
	void splitTest(String nums) {
		Calculator cal = new Calculator();

		String[] actual = cal.split(nums);
		String[] expected = {"1", "+", "2", "/", "3", "-", "4"};

		assertArrayEquals(expected, actual);
	}

}
