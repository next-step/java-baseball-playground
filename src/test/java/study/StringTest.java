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
    void subString() {
        String actual = "(1,2)";
        String substring = actual.substring(1, actual.length()-1);

        assertThat(actual).contains("1,2");
    }

    @Test
    void split() {
        String str = "1,2";
        String [] splitData = str.split(",");

        assertThat(str).contains("1");
    }

    @Test
    void charAt() {
        String str = "abc";
        assertThatThrownBy(() -> {
            str.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("%d", 4);

    }
}
