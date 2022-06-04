package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * String 클래스에 대한 학습 테스트
 */
public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String tc1 = "1,2";
        String tc2 = "1,";
        String[] resultTC1 = tc1.split(",");
        String[] resultTC2 = tc2.split(",");
        assertThat(resultTC1).contains("1", "2");
        assertThat(resultTC2).containsExactly("1");
    }

    @Test
    void 괄호제거() {
        String tc = "(1,2)";
        String result = tc.substring(1, tc.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치 문자를 가져오는 테스트")
    void 문자위치() {
        String tc = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    tc.charAt(3);
                })
                .withNoCause();
    }
}
