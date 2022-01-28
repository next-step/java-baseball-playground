package study;

import org.junit.jupiter.api.Assertions;
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
    void testSplit() {
        String oneAndTwo = "1,2";

        String[] result = split(oneAndTwo);

        String one = result[0];
        String two = result[1];

        assertThat(result).contains(one);
        assertThat(result).contains(two);
    }

    @Test
    void onlyOneReturn() {
        String one = "1";
        String[] result = split(one);
        assertThat(result).containsExactly(one);
    }

    @Test
    void getStringAfterSubstring() {
        String str = "1,2";
        assertThat(substring()).isEqualTo(str);
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 IndexOutOfBoundsException 예외가 발생한다.")
    void getStringIndex() {
        String str = "abc";

        assertThat("a").isEqualTo(String.valueOf(str.charAt(0)));
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> str.charAt(3));
    }

    private String substring() {
        String str = "(1,2)";
        char[] chars = str.toCharArray();
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                index = i;
            }
            if (chars[i] == ')') {
                str = str.substring(index + 1, i);
            }
        }

        return str;
    }

    private String[] split(String str) {
        return str.split(",");
    }
}
