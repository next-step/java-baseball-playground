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
        String[] strings = "1,2".split(",");
        String[] strings1 = "1".split(",");

        // assertThat(strings).containsExactly("2", "1"); 이 경우 에러, containsExactly 는 순서까지 검증한다.

        assertThat(strings).containsExactly(strings[0], strings[1]); // 이 경우는 containsExactly 로 순서까지 검증 하는게 낫다
        assertThat(strings1).contains("1"); // 이 경우 하나이기 때문에 그냥 contains 로 검증하는 것이 낫다.
    }

    @Test
    void subString() {
        String str = "(1,2)";
        String subStr = str.substring(1, str.length() - 1); // substring 은 첫 번째 매개변수는 포함 ~ 마지막 매개변수는 미포함
        //범위 내에 있는 문자열을 가지고 온다.

        assertThat(subStr).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 테스트 및 벗어난 인덱스 에러 테스트")
    void charAt() {
        String str = "abc";
        char ch = str.charAt(0);

        assertThat(ch).isEqualTo('a');

        assertThatExceptionOfType(IndexOutOfBoundsException.class) // 예상되는 예외 클래스를 넣어준다.
                .isThrownBy(() -> { // 예외를 발생 시킨다
                    str.charAt(3);
                })
                .withMessageContaining("index out of range"); // 예상되는 예외 메시지를 매칭해야 한다.
        // containing 이니만큼 예외 메시지의 일부만 들어가 있으면 된다.
    }
}
