package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
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

    @Test
    void contains() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains(actual[0],actual[1]);
    }

    @Test
    void containsExactly() {
        String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly(actual[0],actual[1]);
    }

    // 요구사항 2
    @Test
    void substring() {
        String str = "(1,2)".substring(1,4);
        assertThat(str).isEqualTo("1,2");
    }

    // 요구사항 3
    @Test
    void charAt() {
        char oneChar = "123".charAt(0);
        System.out.println(oneChar);
    }



}
