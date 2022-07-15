package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
	@Test
	void replace() {
		String actual = "abc".replace("b", "d");
		assertThat(actual).isEqualTo("adc");
	}

	@Test
	void split() {
		String[] actual = "1,2".split(",");
		assertThat(actual).contains("1");
	}

	@Test
	void splitOneElement() {
		String[] actual = "1".split(",");
		assertThat(actual).containsExactly("1");
	}

	@Test
	void substring() {
		final String given = "(1,2)";
		String parsedStr = given.substring(1, given.length() - 1);
		assertThat(parsedStr).isEqualTo("1,2");
	}

	@DisplayName("string 에서 charAt() 으로 특정 위치의 문자 찾을 때 위치 값 벗어나는 경우 테스트")
	@Test
	void getCharFromStringIndexOutOfRange() {
		final String given = "abc";
		assertThatThrownBy(() -> {
			char findChar = given.charAt(3);
		}).isInstanceOf(IndexOutOfBoundsException.class)
				.hasMessageContaining("String index out of range: 3");
	}
}
