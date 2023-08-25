package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)".substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        char actual = "abc".charAt(1);
        assertThat(actual).isEqualTo('b');
    }

    @Test
    void StringIndexOutOfBound() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            "abc".charAt(4);
        }).withMessageMatching("String index out of range: \\d+");
    }


}
