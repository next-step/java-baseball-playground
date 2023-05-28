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

    /**
     * 학습테스트 - 요구사항 1 : split()
     */
    @Test
    void split_test1() {
        // given
        String givenStr = "1,2";

        // when
        String[] splitResult = givenStr.split(",");

        // then
        assertThat(splitResult).containsExactly("1", "2");
    }

    @Test
    void split_test2() {
        // given
        String givenStr = "1";

        // when
        String[] splitResult = givenStr.split(",");

        // then
        assertThat(splitResult).containsExactly("1");
    }
    /**
     * 학습테스트 - 요구사항 2 : subString()
     */
    @Test
    void subString_test() {
        // given
        String givenStr = "(1,2)";

        // when
        String result = givenStr.substring(1, 4);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    /**
     * 학습테스트 - 요구사항 3 : charAt()
     */
    @Test
    @DisplayName("Stirng클래스의 charAt() 메소드로 특정 위치의 문자를 가져온다.")
    void charAt_success_test() {
        // given
        String givenStr = "abc";

        // when
        char result = givenStr.charAt(1);

        // then
        assertThat(result).isEqualTo("b");
    }
    @Test
    @DisplayName("Stirng클래스의 charAt() 메소드로 특정 위치의 문자를 가져오다가, 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    void charAt_fail_test() {
        // given
        String givenStr = "abc";

        // when
        // then
        assertThatThrownBy(() -> {
            givenStr.charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");

    }
}
