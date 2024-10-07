package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        final String[] actual = "1,2".split(",");
        assertThat(actual).contains("1");
        assertThat(actual).contains("2");
    }

    @Test
    void split2() {
        final String[] actual = "1".split(",");
        assertThat(actual).contains("1");
    }

    @Test
    void substring() {
        final String before = "(1,2)";
        final String actual = before.substring(1,before.length()-1);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        final String string = "abc";
        assertThrows(IndexOutOfBoundsException.class, () -> string.charAt(4));
    }
}
