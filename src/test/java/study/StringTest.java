package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void replace1() {
        String[] split = "1,2".split(",");
        assertThat(split).isEqualTo(new String[]{"1", "2"});
    }

    @Test
    void replace2() {
        String actual = "(1,2)";
        String result = actual.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void replace3() {
        assertThatThrownBy(() -> {
            String str = "abc";
            str.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");
    }
}
