package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split(){
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1","2");
    }

    @Test
    void spilt2(){
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void subString(){
        String actual = "(1,2)".substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void charAt(){
        char actual = "abc".charAt(1);
        assertThat(actual).isEqualTo('b');
    }

    @Test
    @DisplayName("charAtExceptionText")
    void chatAtException(){
        assertThatThrownBy(() -> {
            char c = "abc".charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 4");
    }



}
