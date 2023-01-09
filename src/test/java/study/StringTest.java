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

    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인한다.")
    @Test
    void split() {
        String source = "1,2";
        String[] split = source.split(",");
        assertThat(split).contains("1","2");
    }

    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인한다.")
    @Test
    void splitOnlyOne() {
        String source = "1";
        String[] split = source.split(",");
        assertThat(split).containsExactly("1");
    }

    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하는지 확인한다.")
    @Test
    void subString() {
        String source = "(1,2)";
        String substring = source.substring(1,4);
        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지 확인한다.")
    @Test
    void charAt() {
        String source = "abc";
        char c = source.charAt(1);
        assertThat(c).isEqualTo('b');
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 확인한다.")
    void charAtStringIndexOutOfBoundsException이() {
        String source = "abc";
        assertThatThrownBy(() -> {
            source.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 3");
    }

}
