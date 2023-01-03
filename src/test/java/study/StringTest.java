package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    /*
        AssertJ Exception Assertions 문서 참고
        https://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html#exception-assertion
    */
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        final String value = "1,2";
        final String[] actual = value.split(",");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void substring() {
        final String value = "(1,2)";
        final String actual = value.substring(1, value.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치 문자 가져오기[실패] - 위치 값 벗어남")
    void charAt_ThrownBy() {
        final String value = "abc";
        final int len = value.length();
        assertThatThrownBy(() -> value.charAt(len))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + len);
    }

    @Test
    @DisplayName("특정 위치 문자 가져오기[실패] - 위치 값 벗어남")
    void charAt_ExceptionOfType() {
        final String value = "abc";
        final int len = value.length();
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> value.charAt(len))
                .withMessageMatching("String index out of range: " + len);
    }
}
