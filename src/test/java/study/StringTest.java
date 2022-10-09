package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    //요구사항 1
    @Test
    void splitCommaToManyNumber() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1");
        assertThat(actual).contains("2");
    }

    @Test
    void splitCommaToOneNumber() {
        String[] actual2 = "1".split(",");
        assertThat(actual2).containsExactly("1");
    }

    //요구사항 2
    @Test
    void substringWithoutParenthesis() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    //요구사항 3
    @Test
    @DisplayName("charAt()메소드를 활용해 특정위치의 문자를 가져온다.")
    void takeAlphabetByIndexNumber() {
        char actual = "abc".charAt(2);
        assertThat(actual).isEqualTo('c');
    }

    @Test
    @DisplayName("takeAlphabetByIndexNumber()의 범위가 넘어갔을 때에 예외처리Test")
    void takeAlphabetByIndexNumberException() {
        String value = "abc";
        assertThatThrownBy(() -> {
            value.charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }
}
