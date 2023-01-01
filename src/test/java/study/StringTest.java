package study;

import org.junit.jupiter.api.DisplayName;
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
    void _1과_2가_나눠지는지_테스트() {
        String[] str = "1,2".split(",");
        assertThat(str).contains("1","2");
    }

    @Test
    void substring_테스트() {
        String str = "(1,2)";
        String sub_str = str.substring(1, str.length()-1);
        assertThat(sub_str).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정위치 문자 가져오기 테스트")
    void charAt_테스트() {
        String text = "abc";
        assertThat(text.charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("위치 값을 벗어나면 StringIndexOutOfBoundsException 테스트")
    void charAt_indexOut_테스트() {
        String text = "abc";

        assertThatThrownBy(() -> {
            text.charAt(text.length());
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}
