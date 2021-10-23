package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void recommend1() {
        String[] str1 = "1,2".split(",");
        String[] str2 = "1".split(",");
        assertThat(str1).contains("1", "2");
        assertThat(str2).containsExactly("1");
    }

    @Test
    void recommend2() {
        String str = "(1,2)".substring(1,4);
        assertThat(str).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String의 charAt() 메소드 테스트")
    void recommend3() {
        String str = "abc";
        char a = str.charAt(0);
        //char d = str.charAt(3);
    }
}


