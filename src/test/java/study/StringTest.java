package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {
  @Test
  void replace() {
    String actual = "abc".replace("b", "d");
    assertThat(actual).isEqualTo("adc");
  }

  @Test
  void split() {
    String[] actualArr = "1,2".split(",");
    assertThat(actualArr).contains("1", "2");
    assertThat(actualArr).containsExactly("1", "2");
  }

  @Test
  void split2() {
    String[] actual = "1".split(",");
    assertThat(actual).contains("1");
    assertThat(actual).containsExactly("1");
  }

  @Test
  void substring() {
    String actual = "(1,2)".substring(1, 4);
    assertThat(actual).isEqualTo("1,2");
  }

  @Test
  @DisplayName("String에 charAt 메소드를 활용해 특정위치의 문자를 가져오는 테스트")
  void charAt() {
    String abc = "abc";

    char indexChar = abc.charAt(2);
    int index = abc.indexOf(indexChar);
    int size = abc.length();

    assertThat(indexChar + "").isEqualTo(abc.charAt(index) + "");

    assertThatExceptionOfType(IndexOutOfBoundsException.class)
        .isThrownBy(() -> {
          char indChar = abc.charAt(4);
          assertThat(indChar + "").isEqualTo(abc.charAt(index) + "");

        }).withMessageMatching("String index out of range: \\d+");
  }
}
