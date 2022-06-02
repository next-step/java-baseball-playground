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
    void splitCommaNumbersStringIntoTwoGroup() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1");
        assertThat(actual).contains("2");
    }

    @Test
    void splitSingleNumberStringIntoSame() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void substringCommaNumbersWithBracketsToNumbersStringWithoutBrackets() {
        String actual = "(1,2)".substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열에서 String.charAt()으로 0번째 위치 문자를 가져온다")
    void charAtFromString() {
        char actual = "abc".charAt(0);
        assertThat(actual).isEqualTo('a');
    }

    @Test
    @DisplayName("String.charAt()에서 문자열 Index 범위를 넘어선 Index 에 접근할 때 IndexOutOfBoundsException 이 발생하는자 확인한다")
    void charAtOccurExceptionWhenAccessingOutOfBounds() {
        assertThatThrownBy(() -> {
            char actual = "abc".charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
