package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	void replace() {
		String actual = "abc".replace("b", "d");
		assertThat(actual).isEqualTo("adc");
	}

	@Test
	void splitOneCommaTwo() {
		String[] oneCommaTwo = "1,2".split(",");
		assertThat(oneCommaTwo).containsExactly("1", "2");
	}

	@Test
	void splitOneComma() {
		String[] oneComma = "1".split(",");
		assertThat(oneComma).contains("1");
	}

	@Test
	void removeBracket() {
		String oneTwoInBracket = "(1,2)";
		String onlyNumber = oneTwoInBracket.substring(oneTwoInBracket.indexOf("(") + 1, oneTwoInBracket.indexOf(")"));
		assertThat(onlyNumber).isEqualTo("1,2");
	}
}
