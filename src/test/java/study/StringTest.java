package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void splitTest() {
        String[] split = "1,2".split(",");
        assertThat(split[0]).isEqualTo("1");
        assertThat(split).contains("1");
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    void subStringTest() {
        String givenValue = "(1,2)";
        String subStringValue = givenValue.substring(1, 4);
        assertThat(subStringValue).isEqualTo("1,2");
        assertThat(subStringValue).contains("1");
    }

    @Test
    @DisplayName("예외 테스트")
    void charATTest() {
        String givenValue = "abc";

        assertThatThrownBy(() -> {
            givenValue.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    givenValue.charAt(3);
                }).withMessageMatching("String index out of range: 3");
//                }).withMessageMatching("Index: \\d+, Size: \\d+");
    }
}
