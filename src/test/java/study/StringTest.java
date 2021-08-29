package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void 요구사항1() {
        String[] split = "1,2".split(",");
        assertThat(split.length).isEqualTo(2);
        assertThat(split[0]).isEqualTo("1");
        assertThat(split[1]).isEqualTo("2");
    }

    @Test
    void 요구사항1_1() {
        String[] split = "1".split(",");
        assertThat(split[0]).isEqualTo("1");
        assertThat(split.length).isEqualTo(1);
        assertThat(split[0].contains("1")).isEqualTo(true);
    }

    @Test
    void 요구사항2() {
        String str = "(1,2)";
        String substring = str.substring(1, str.length() - 1);
        assertThat(substring.contains("(")).isEqualTo(false);
        assertThat(substring.contains(")")).isEqualTo(false);
    }

    @Test
    void 요구사항3() {
        String str = "abc";
        assertThatThrownBy(() -> {
            char c = str.charAt(4);
            assertThat(c).isEqualTo('c');
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Size : 3, Index : 0 ~ 2");
    }

    @Test
    void 요구사항3_1() {
        String str = "acb";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    assertThat(str.charAt(3)).isEqualTo('b');
                });
    }
}
