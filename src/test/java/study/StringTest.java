package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] test1 = "1,2".split(",");
        assertThat(test1).contains("1","2");

        String[] test2 = "1".split(",");
        assertThat(test2).containsExactly("1");
    }

    @Test
    void substring() {
        String test3 = "(1,2)".substring(1,4);
        assertThat(test3).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() - 특정 index의 문자 구하기 메소드")
    void charAt() {
        String test4 = "abc";
        char temp = test4.charAt(0);
        assertThat(temp).isEqualTo('a');

    }
    @Test
    @DisplayName("charAt() - 위치값을 벗어나 발생하는 예외")
    void chatAtException() {
        //when
        String test4 = "abc";
        //then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(()->{
                    test4.charAt(4);
                }).withMessageMatching("String index out of range: 4");
    }

}
