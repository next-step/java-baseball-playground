package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("1,2를 분리하여 배열로 만들기 - split 테스트")
    void split() {
        String[] strings1 = "1,2".split(",");
        String[] strings2 = "1".split(",");

        assertThat(strings1).containsExactly("1", "2");
        assertThat(strings2).contains("1");
    }

    @Test
    @DisplayName("(1,2)값에서 ()분리하기 - substring 테스트")
    void substring() {
        String target = "(1,2)";
        String result = target.substring(1, target.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정위치의 문자열 가져오기 - charAt() 테스트")
    void charAtTest() {
        String target = "abc";
        char searchTarget = 'c';
        assertThat(target.charAt(2)).isEqualTo(searchTarget);

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> target.charAt(4))
                .withMessageContaining("String index out of range: %s", 4);

        assertThatThrownBy(() -> target.charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
