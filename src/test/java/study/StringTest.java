package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    //요구사항 1
    @Test
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1", "2");
        assertThat(actual).containsExactly("1", "2");
    }

    //요구사항 2
    @Test
    void substring() {
        String actual = "(1,2)".substring(1, 3);
        assertThat(actual).isEqualTo("1,2");
    }



    //요구사항 3
    @Test
    void charat() {
        String actual = "abc";

        char A = actual.charAt(0);
        char B = actual.charAt(1);
        char C = actual.charAt(2);
        assertThat(A).isEqualTo('a');
        assertThat(B).isEqualTo('b');
        assertThat(C).isEqualTo('c');
    }

    @Test
    void IndexOutOfBoundsException() {
        assertThatThrownBy(() -> {
            String str = "abc";
            char ch = str.charAt(3);
        })
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("out of range ; range : 3 ");
        }
    }




