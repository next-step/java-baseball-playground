package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("요구사항 1")
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).contains("1", "2");

        values = "1".split(",");
        assertThat(values).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2")
    void substring() {
        String value = "(1,2)";
        String substring = value.substring(1, value.length() - 1);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3:" +
                 "charAt() 메서드를 활용해서 특정 위치의 문자를 가져올 때 위치 값을 벗어나면" +
                 "StringIndexOutOfBoundsException이 발생한다.")
    void charAt() {
        Assertions.assertThatThrownBy(() -> {
            "abc".charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
