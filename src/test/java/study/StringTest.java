package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    // 요구사항 1
    @Test
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual[0]).isEqualTo("1");
    }
}
