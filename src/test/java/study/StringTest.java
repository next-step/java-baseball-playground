package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void splitTest_1() {
        String[] actual = "1,2".split(",");

        assertThat(actual).contains("1");
        assertThat(actual).contains("2");

        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void subString() {
        String actual = "(1,2)".substring(1, 4);

        assertThat(actual).isEqualTo("1,2");
    }
}
