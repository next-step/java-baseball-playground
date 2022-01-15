/*
junit을 이용한 단위테스트 연습 01
 */

package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("isEqualTo - assertThat() 안의 값과 isEqualTo 안의 값이 같은지 테스트")
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
        //contains - assertThat 안에 포함되는 값을 확인
        //containsExactly - assertThat 안에 포함되는 모든 값을 확인 (모든값을 괄호 안에 명시해줘야 테스트 실패가 뜨지않음)
    void split() {
        String[] values = "1".split(",");
        values = "1,2".split(",");
        assertThat(values).contains("1");
        assertThat(values).contains("2");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String str = "(1,2)".substring(1, 4); //substring 을 통해 ()를 제거
        assertThat(str).isEqualTo("1,2"); //맞는지 확인
    }

    @Test
        //예상되는 에러가 뜨는 상황을 일부로 연출하여 테스트한다
        //charAt(index): 문자열에서 index에 위치한 char를 반환한다
        //StringIndexOutOfBoundsException: 배열에 할당되지 않은 메모리(인덱스)에 접근했을때 뜨는 에러문
        //예외를 실행하지 않으면
        //Expecting code to raise a throwable : isInstanceOf() 함수에 입력된 오류가 발생하지 않을 경우 뜨는 에러
        //예상된 오류가 뜨지않으면 나온다
    void charAt() {
        String str = "abc";
        int index = 3;
        //에러를 연출할 내용을 넣는다
        assertThatThrownBy(() -> {
            str.charAt(index);
            //예상되는 에러를 지정하는 함수
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                //예상되는 에러에 나오는 메시지에 들어있을 내용을 적는다 이게 맞으면 태스트 성공, 아니라면 테스트실패
                .hasMessageContaining("%d", index);
    }

    @Test
    void charAt2() {
        String str = "abc";
        int index = 4;

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    str.charAt(index);
                    //withMessageContaining과 다르게 ex).withMessageContaining("%d", index);
                    //withMessageMatching 에러가는 문장을 정확이 맞춰야함(index값도 %d로 넣으면 에러가 생김)
                }).withMessageMatching("String index out of range: 4");
    }
    //자주 발생하는 예외처리 경우들
            /* assertThatIllegalArgumentException()
                assertThatIllegalStateException()
                assertThatIOException()
                assertThatNullPointerException()*/


}

