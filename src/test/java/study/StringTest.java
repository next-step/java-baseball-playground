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
        String[] oneTwo = "1,2".split(",");
        System.out.println("oneTwo = " + Arrays.toString(oneTwo));
        assertThat(oneTwo).contains("1");
        assertThat(oneTwo).contains("2");
        assertThat(oneTwo).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String oneTwo = "(1,2)".substring(1, 4);
        System.out.println("oneTwo = " + oneTwo);
        assertThat(oneTwo).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAtTest")
    void charAt() {
        String actual = "abc";
        assertThat(actual.charAt(0)).isEqualTo('a');
        assertThat(actual.charAt(1)).isEqualTo('b');
        assertThat(actual.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> {
            actual.charAt(actual.length()+1);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("range: " + (actual.length()+1));

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    actual.charAt(actual.length() + 1);
                }).withMessageMatching("String index out of range: " + (actual.length()+1));
    }


}
