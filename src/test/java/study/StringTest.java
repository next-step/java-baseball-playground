package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] actual2 = "1".split(",");
        assertThat(actual2).contains("1");
        System.out.println(Arrays.toString(actual2));

        String[] acutal1 = "1,2".split(",");
        assertThat(acutal1).contains("1", "2");
        assertThat(acutal1).containsExactly("1", "2");
        System.out.println(Arrays.toString(acutal1));

        String actual3 = "(1,2)".substring(1, 4);
        assertThat(actual3).isEqualTo("1,2");
        System.out.println(actual3);
    }

    @Test
    @DisplayName("charAt test")
    void charAt() {
        //given
        String str = "abc";
        int index = 2;

        //when
        char c = str.charAt(index);

        //then
        assertThat(c).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt에서 assertThatThrownBy를 사용하여 Exception 처리")
    void charAtException() {

        String str = "abc";
        int index = 21;

        assertThatThrownBy(() -> {
            char c = str.charAt(index);
            assertThat(c).isEqualTo('c');
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("%d", index);
    }

    @Test
    @DisplayName("charAt에서 assertThatExceptionOfType 사용하여 Exception 처리")
    void charAtException2() {

        String str = "abc";
        int index = 21;

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char c = str.charAt(index);
                    assertThat(c).isEqualTo('c');
                }).withMessageContaining("%d", index);
    }

}




