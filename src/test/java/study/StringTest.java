package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split_1() {
        String str = "1,2";
        String[] split = str.split(",");

        assertThat(split).contains("1", "2"); // 중복 o, 순서 상관 x, 값이 일치하기만 하면 ok
        assertThat(split).containsOnly("2", "1", "2"); // 중복 o, 순서 상관 x, 원소 갯수 일치 해야됨
        assertThat(split).containsExactly("1", "2"); // 중복 x, 순서 상관 o, 순서까지 정확하게 일치 해야됨
    }

    @Test
    void split_2() {
        String str = "1";
        String[] split2 = str.split(",");

        assertThat(split2).containsOnly("1");
    }

    @Test
    void substring() {
        String str = "(1,2)";
        str = str.substring(1, str.length() - 1);

        assertThat(str).isEqualTo("1,2");
    }

    @Test
    void string_index_out_of_bounds_exception() {
        String str = "abc";
        int index = 4;

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(index);
                }).withMessageMatching("String index out of range: " + index);
    }
}
