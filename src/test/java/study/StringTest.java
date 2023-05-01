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
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1","2");

        values = "1".split(",");
        assertThat(values).contains("1");
    }

    @Test
    void subString() {
        String input = "(1,2)";
        String substring = input.substring(1, input.length() - 1);
        assertThat(substring).isEqualTo("1,2");
    }

    // StringIndexOutOfBoundsException: 배열에 할당되지 않은 메모리(인덱스)에 접근했을때 뜨는 에러문
    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException")
    void charAt() {
        String input = "abc"; // String.length 의 길이는 2 이다.
        int index = 3;

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    input.charAt(index);
                // (중요) withMessageMatching 에러 문장을 정확히 기재해야 통과
                }).withMessageMatching("String index out of range: 3");
    }



    // Expecting code to raise a throwable. : isInstanceOf() 함수에 입력된 오류가 발생하지 않을 경우 뜨는 에러
    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException")
    void charAt2() {
        String input = "abc";
        int index = 10;
        assertThatThrownBy(() -> {
            input.charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)  // 예상되는 에러를 지정하는 함수
                 .hasMessageContaining("%d", index); // 예상되는 에러에 나오는 메세지에 들어있을 내용을 적는다. 맞으면 성공, 아니면 실패
    }


}
