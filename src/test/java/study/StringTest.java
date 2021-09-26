package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        // "1,2"을 ,로 split 했을 때 1과 2로 분리되는지
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");

        // "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지
        values = "1".split(",");
        assertThat(values).contains("1");

    }

    @Test
    void substring() {
        // "(1,2)" 값이 주어졌을 때 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환
        String input = "(1,2)";
        String output = input.substring(1, input.length()-1);
        assertThat(output).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메소드 테스트")
    void charAt() {
        // "abc" 값이 주어졌을 때 charAt() 메소드를 활용해 특정 위치의 문자를 반환
        String input = "abc";
        assertThat(input.charAt(1)).isEqualTo('b');

        // 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 확인
        assertThatThrownBy(() -> input.charAt(4)).isInstanceOf(StringIndexOutOfBoundsException.class);

    }
}
