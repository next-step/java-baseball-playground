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
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("2", "1", "2");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void subString() {
        String actual = "(1,2)".substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치 문자 가져오기 has - 실패 케이스")
    void stringIndexException1() {
        String str = "abcde";

        // assertThatThrownBy 사용
       assertThatThrownBy(() -> {
            for(int i = 0; i < str.length() + 1; i++) {
                char c = str.charAt(i);
            }
        }).isInstanceOf(IndexOutOfBoundsException.class)
               .hasMessageContaining("%d", str.length());     // 에러 메시지가 다음 값을 포함하고 있는지 검사
    }

    @Test
    @DisplayName("특정 위치 문자 가져오기 with - 실패 케이스")
    void stringIndexException3() {
        String str = "abcde";
        int index = 10;

        // assertThatExceptionOfType 사용
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char c = str.charAt(index);
                }).withMessageContaining("%d", index);
    }


}
