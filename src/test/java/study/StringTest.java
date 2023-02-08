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
    void test() {
        String[] actual = {"2"};
        String s = "123";

        System.out.println(s.indexOf(actual[0]));
        System.out.println(s.contains(actual[0]));
    }

    // 요구사항 1
    @Test
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual[0]).isEqualTo("1");
    }

    @Test
    void contains() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains(actual[0],actual[1]);
    }

    @Test
    void containsExactly() {
        String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly(actual[0],actual[1]);
    }

    // 요구사항 2
    @Test
    void substring() {
        String str = "(1,2)".substring(1,4);
        assertThat(str).isEqualTo("1,2");
    }

    // 요구사항 3
    @Test
    void charAt() {
        char oneChar = "123".charAt(5);
        System.out.println(oneChar);
    }

    @Test
    @DisplayName("입력값 범위 밖일 경우 StringIndexOutOfBoundsException 확인")
    public void StringIndexOutOfBoundsException() {
        String str = "abc";

        assertThatThrownBy(() -> str.charAt(str.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String 범위를 넘어섰습니다.")
                .hasMessageContaining(String.valueOf(str.length()));
    }




}
