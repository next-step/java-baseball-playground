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

    //"1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
    //"1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
    @Test
    void split() {
        String[] split = "1,2".split(",");
        assertThat(split).contains("1");
        assertThat(split).containsExactly("1", "2");
    }

    //"(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
    @Test
    void substring() {
        String substring = "(1,2)".substring(1,4);
        assertThat(substring).isEqualTo("1,2");
    }

    //"abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
    //String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
    //JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.

    @Test
    @DisplayName("문자열에서 String.charAt()으로 0번째 위치 문자를 가져온다.")
    void charAt() {
        char c = "abc".charAt(0);
        assertThat(c).isEqualTo('a');
    }

    @Test
    @DisplayName("String.charAt()에서 문자열 Index 범위를 넘어선 Index에 접근할 때 IndexOutOfBoundsException 이 발생하는자 확인한다.")
    void result() {
        assertThatThrownBy(() -> {
            "abc".charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
