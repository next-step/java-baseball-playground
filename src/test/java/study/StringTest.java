package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1", "2");
    }

    @Test
    void split2() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @DisplayName("문자열 범위 밖의 인덱스로 문자열을 참조할 때 에러가 발생한다.")
    @Test
    void charAt() {
        String actual = "abc";
        assertThatThrownBy(() -> actual.charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
