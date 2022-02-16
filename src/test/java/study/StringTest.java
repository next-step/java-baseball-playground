package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
//        String[] split = "1,2".split(",");
//        assertThat(split).contains("1", "2");
//        assertThat(split).containsExactly("1", "2");
//
//        assertThat(split).contains("1"); //success
//        assertThat(split).containsExactly("1"); //fail

//        String split = "(1,2)";
//        split = split.substring(1,split.length()-1);
//        assertThat(split).isEqualTo("1,2");


    }

    @Test
    void charAt() {
        //given
        String str = "abc";

        //when
        char c = str.charAt(2);

        //then
        assertThat(c).isEqualTo('c');
    }

    @Test
    @DisplayName("assertThatThrownBy Exception")
    void charAtException() {

        String str = "abc";

        assertThatThrownBy(() -> {
            char c = str.charAt(15);
            assertThat(c).isEqualTo('c');
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("%d", 15);
    }

    @Test
    @DisplayName("assertThatExceptionOfType Exception")
    void charAtException2() {

        String str = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char c = str.charAt(15);
                    assertThat(c).isEqualTo('c');
                }).withMessageContaining("%d", 15);
    }
}
