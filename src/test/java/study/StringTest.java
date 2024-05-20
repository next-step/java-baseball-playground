package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String input = "1,2";
        final String [] expected = new String[]{"1","2"};

//        testSplitRoutine(input, expected);
        String [] result = input.split(",");
        assertThat(result).containsExactly("1","2");

    }

    @Test
    void split_one_element() {
        String input = "1";
        final String [] expected = new String[]{"1"};

//        testSplitRoutine(input, expected);
        String [] result = input.split(",");
        assertThat(result).containsExactly("1");
    }

    private void testSplitRoutine(String input, String[] expected) {
        String [] result = input.split(",");

        assertThat(result.length).isEqualTo(expected.length);
        for(int i = 0 ; i < result.length ; i++){
            assertThat(result[i]).isEqualTo(expected[i]);
        }
    }

    @Test
    void substring() {
        String input = "(1,2)";
        final String expected = "1,2";

        assertThat(removeParentheses(input)).isEqualTo(expected);
    }

    private String removeParentheses(String input) {
        return input.substring(1,input.length()-1);
    }

    @Test
    @DisplayName("i번째 글자 가져오는 charAt 테스트")
    void charAt() {
        String input = "abc";
        int inputIdx =  1;
        char expected = 'b';

        char actual = input.charAt(inputIdx);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("위치값 벗어난 경우 charAt 테스트")
    void charAt_StringIndexOutOfBoundsException() {
        String input = "abc";
        int inputIdx =  -1;

        assertThatThrownBy(() -> input.charAt(inputIdx))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
