package study;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replaceTest() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }


    @DisplayName("REQUEST 1")
    @Test
    void splitTest() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1").contains("2");
        assertThat(actual).containsAll(Arrays.asList("1","2"));
//        assertThat(actual).containsAll(Arrays.asList("1","2","3"));
        assertThat(actual).containsExactly("1","2");

        Condition<String> cond = new Condition<>(s -> s.length() == 1, "Single String");
        assertThat(new String[]{"1", "2", "34"}).are(cond);
    }

    String eraseBrackets(String str) {
        return str.length() > 1 && str.charAt(0) == '(' && str.charAt(str.length()-1) == ')' ?  str.substring(1, str.length()-1) : str;
    }


    @DisplayName("req2")
    @Test
    void eraseBracketsTest() {
        String actual = "(1,2)";
        assertThat(eraseBrackets(actual)).isEqualTo("1,2");
    }

    @DisplayName("req3 :: 특정 위치의 문자 가져오기")
    @Test
    void charAtTest() {
        String actual = "abc";
        int idx = 0;

//        assertThatThrownBy(() -> {
//            assertThat(actual.charAt(idx)).isEqualTo('a');
//
////            [AssertionError]
////            Expecting code to raise a throwable.
////            assertThatThrownBy() 를 사용한 경우, error가 없으면 뜬다. -> 에러 발생 상황을 test
////            assertThatCode()를 사용하자
//
//        }).isInstanceOf(IndexOutOfBoundsException.class)
//                .hasMessageContaining("Index: %d Size: %d", idx, actual.length());

//        assertThatCode(() -> {
//            assertThat(actual.charAt(idx)).isEqualTo('a');
//        }).isInstanceOf(IndexOutOfBoundsException.class)
//                .hasMessageContaining("Index: %d Size: %d", idx, actual.length())
//                .doesNotThrowAnyException();

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    assertThat(actual.charAt(idx)).isEqualTo('a');
                })
                .withMessageContaining("Index: %d", idx);
    }

}
