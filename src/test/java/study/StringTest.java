package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("특정 문자 치환하기")
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("1, 2를 ,으로 분리 했을 경우")
    void split1(){
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1","2");
    }

    @Test
    @DisplayName("1을 ,으로 분리 했을 경우")
    void split2(){
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    @DisplayName("문자열 자르기 테스트 (1,2) 에서 1,2만 반환")
    void substring(){
        String actual = "(1,2)".substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }


    @Test
    @DisplayName("특정 위치의 문자를 가져오기")
    void charAt(){
        char a = "abc".charAt(0);
        char c = "abc".charAt(2);
        assertThat(a).isEqualTo('a');
        assertThat(c).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt 사용시 인덱스가 넘어가는 수일 경우 오류")
    void charAtOutOfBoundException(){
        assertThatThrownBy(() -> {
            char a = "abc".charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
