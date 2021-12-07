package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    public void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    public void split_completed() {
        String[] numbers = "1,2".split(",");
        assertThat(numbers).contains("1", "2");

        numbers = "1".split(",");
        assertThat(numbers).containsExactly("1");
    }

    @Test
    public void removeString() {
        String numTuple = "(1,2)";
        String num = numTuple.substring(1, 4);
        assertThat(num).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 도출")
    public void getCertainPositionString() {
        String givenString = "abc";
        int index = 3;

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    givenString.charAt(index);
                }).withMessageContaining("String index out of range: 3");
    }
}