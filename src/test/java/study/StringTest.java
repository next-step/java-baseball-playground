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
    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    void stringSplitWithComma() {
        //given
        String input = "1,2";
        //when
        String[] result = input.split(",");
        //then
        assertThat(result).contains("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    void stringSplitWithComma2() {
        //given
        String input = "1";
        //when
        String[] result = input.split(",");
        //then
        assertThat(result).containsExactly("1");
    }

    public String StringSubstring() {
        //given
        String input = "(1,2)";
        //when
        return input.substring(1, input.length() - 1);
        //then
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    void stringCharAtMethodTest() {
        //given
        String input = "abc";
        //when
        //then
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    void stringCharAtMethodExceptionTest() {
        //given
        String input = "abc";
        //when
        assertThatThrownBy(() -> input.charAt(4))
                .isInstanceOf(IndexOutOfBoundsException.class);
        //then
    }
}
