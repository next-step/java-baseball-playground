package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("replace test")
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("요구사힝 1. split test")
    void array_split() {
        String[] values = "1".split(",");
        assertThat(values).contains("1");

        values = "1,2".split(",");
        assertThat(values).contains("1", "2");
    }

    @Test
    @DisplayName("요구사항 2. substring test")
    void substring() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3. charAt test")
    void chatAt() {
        String input = "abc";
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThatThrownBy(() -> input.charAt(3))
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 3");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> input.charAt(3))
        .withMessageMatching("String index out of range: \\d+");
    }
}
