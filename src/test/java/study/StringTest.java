package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	void replace() {
		// GIVEN
		String actual = "abc";

		// WHEN
		actual = actual.replace("b", "d");

		// THEN
		assertThat(actual).isEqualTo("adc");
	}

	@Test
	void splitOneCommaTwo() {
		// GIVEN
		String oneCommaTwo = "1,2";

		// WHEN
		String[] splitedList = oneCommaTwo.split(",");

		// THEN
		assertThat(splitedList).containsExactly("1", "2");
	}

	@Test
	void splitOneComma() {
		// GIVEN
		String oneComma = "1";

		// WHEN
		String[] splitedList = oneComma.split(",");

		// THEN
		assertThat(splitedList).contains("1");
	}

	@Test
	void removeBracket() {
		// GIVEN
		String oneTwoInBracket = "(1,2)";

		// WHEN
		String onlyNumber = oneTwoInBracket.substring(oneTwoInBracket.indexOf("(") + 1, oneTwoInBracket.indexOf(")"));

		// THEN
		assertThat(onlyNumber).isEqualTo("1,2");
	}

	@Test
	void StringIndexOutOfBoundsExceptionThrownBy() {
		// GIVEN
		String abc = "abc";

		// THEN
		assertThatThrownBy(() -> {
			abc.charAt(3);
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range: 3");
	}

	@Test
	void StringIndexOutOfBoundsExceptionExceptionOfType() {
		// GIVEN
		String abc = "abc";

		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> {
				abc.charAt(3);
			}).withMessageMatching("String index out of range: 3");
	}
}