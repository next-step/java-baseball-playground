package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    /*
        AssertJ Exception Assertions 문서 참고
        https://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html#exception-assertion
    */

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    //"1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
    @Test
    void split() {
        String literal = "1,2";
        String[] result = literal.split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");
    }

    //"1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
    @Test
    void split2() {
        String literal = "1";
        String[] result = literal.split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring() {
        String literal = "(1,2)";
        String result = literal.substring(0, literal.length() - 1);
        assertThat(result).contains("1,2");
    }

    @DisplayName("charAt으로 특정 위치 문자 가져오기")
    @Test
    void charat() {
        String literal = "abc";
        char result = literal.charAt(1);
        assertThat(result).isEqualTo('b');

        //Exception 처리
        assertThatThrownBy(()->{
            throw new Exception("OutOfBoundException 처리");
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("index:2, Size:2");
    }
}
