package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StringTest {

	@Test
	public void replace() {
		String actual = "abc".replace("b", "d");
		assertThat(actual).isEqualTo("adc");
	}

	@Nested
	@DisplayName("요구사항1")
	class Requirements1 {
		@Test
		@DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
		public void split_test1() {
			String[] actual = "1,2".split(",");

			assertThat(actual).contains("1");
			assertThat(actual).contains("2");

			assertThat(actual).containsExactly("1", "2");
		}

		@Test
		@DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
		public void split_test2() {
			String[] actual = "1".split(",");

			assertThat(actual).containsOnly("1");
		}
	}

	@Nested
	@DisplayName("요구사항2")
	class Requirements2 {

		@Test
		@DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
		public void substring_test1() {
			String given = "(1,2)";
			String actual = given.substring(1, given.length() - 1);

			assertNotNull(actual);
			assertEquals("1,2", actual);
		}
	}

	@Nested
	@DisplayName("요구사항3")
	class Requirements3 {

		@ParameterizedTest
		@CsvSource({"0,a", "1,b", "2,c"})
		@DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
		public void charAt_test1(String givenIndexSource, String expectedString) {
			String given = "abc";

			int givenIndex = Integer.parseInt(givenIndexSource);
            String actual = String.valueOf(given.charAt(givenIndex));

			assertEquals(expectedString, actual);

			assertThatThrownBy(() -> {
				given.charAt(given.length());
			}).isInstanceOf(IndexOutOfBoundsException.class)
				.hasMessageContaining("String index out of range:");
		}
	}

}