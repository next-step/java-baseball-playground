package study;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String value = "1,2";
        String[] splitedValue = value.split(",");
        assertThat(splitedValue).contains("1", "2");
    }

    @Test
    void substring() {
        String value = "1,2".substring(1, 4);
        assertThat(value).isEqualTo("1,2");
    }

    @Test
    @DisplayName("use charAt()")
    void charAt() {
        String value = "abc";
        char result = value.charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 발생")
    void StringIndexOutOfBoundsException() {
        String input = "abc";
        assertThatThrownBy(() -> input.charAt(10))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
