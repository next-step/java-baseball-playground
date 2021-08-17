package study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] oneTwo = "1,2".split(",");
        System.out.println("oneTwo = " + Arrays.toString(oneTwo));
        assertThat(oneTwo).contains("1");
        assertThat(oneTwo).contains("2");
        assertThat(oneTwo).containsExactly("1", "2");
    }
}
