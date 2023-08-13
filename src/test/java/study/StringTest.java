package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");

        values = "1".split(",");
        assertThat(values).contains("1");
    }

    @Test
    public void subString() {
        String input = "(1,2)";
        //String result = input.substring(1, 4);
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    public void charAt() {
        String input = "abc";
        char result = input.charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt assertThatThrownBy Exception 처리 테스트")
    public void charAtException() {
        String target = "abc";
        int index = 10;
        assertThatThrownBy(() -> {
            target.charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: %d", index);
    }

    @Test
    @DisplayName("charAt assertThatExceptionOfType Exception 처리 테스트")
    public void charAtExceptionOfType() {
        String target = "abc";
        int index = 3;
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            assertThat(target.charAt(index)).isEqualTo('c');
        }).withMessageContaining("%d", index);
    }

    @Test
    @DisplayName("parseInt 처리 테스트")
    public void parseInt() {
        int number = 123;
        int result = Integer.parseInt("123");
        assertThat(result).isEqualTo(number);
    }
}



