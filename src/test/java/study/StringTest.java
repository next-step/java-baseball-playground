package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    /**
     * contains() : 배열이 갖고 있는 값들 일부 포함하냐?
     * containsExactly() : 배열에 포함된 모든 값이냐?
     */
    @Test
    void split() {
        String[] split = "1,2".split(",");
        assertThat(split).contains("1","2");

        String[] only1 = "1".split(",");
        assertThat(only1).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)";
        String sub = actual.substring(1, actual.length()-1);
        assertThat(sub).isEqualTo("1,2");
    }

    @DisplayName("IndexOutOfBoundsExceptionTest")
    @Test
    void charAt() {
        String actual = "abc";

    }
}
