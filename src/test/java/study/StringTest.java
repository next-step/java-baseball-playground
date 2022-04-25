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
    void commaSplit1() throws Exception {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void commaSplit2() throws Exception {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void commaSplit3() throws Exception {
        // given
        String str = "(1,2)";
        String actual = str.substring(1, str.length() - 1);

        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName(value = "chatAt을 사용하여 특정 문자열을 추출한다")
    @Test
    void chatAt() throws Exception {
        String str = "abc";

        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
        assertThatThrownBy(() -> str.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 3");
    }


}
