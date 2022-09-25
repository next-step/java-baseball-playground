package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    public void split() {
        String[] values = "1".split(",");
        assertThat(values).contains("1");
        values = "1,2".split(",");
        assertThat(values).containsExactly("1","2");
    }

    @Test
    public void substring() {
        String input = "{1,2}";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 위치 가져오기")
    public void charAt() {
        String input = "abc";
        int idx = 5;
        assertThatThrownBy(() -> {
            input.charAt(idx);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index : %d, Size : %d", idx, input.length());
    }

    @Test
    @DisplayName("문자열 위치 가져오기2")
    public void charAt2() {
        String input = "abc";
        int idx = 5;
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    input.charAt(idx);
                }).withMessageMatching("Index: \\d+, Size: \\d+");
    }
}
