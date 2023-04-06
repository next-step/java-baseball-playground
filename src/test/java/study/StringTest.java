package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1","2");

        values = "1".split(",");
        assertThat(values).contains("1");
    }

    @Test
    void subString() {
        String input = "(1,2)";
        String substring = input.substring(1, input.length() - 1);
        assertThat(substring).isEqualTo("1,2");

    }
}
