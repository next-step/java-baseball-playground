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
    @DisplayName("요구사항1")
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1","2");
        String[] only1 = actual[0].split(",");
        assertThat(only1).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2")
    void substring() {
        String actual = "(1,2)".substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3")
    void stringIndexOutOfBoundsException() {
        String actual = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            for(int i=0; i<actual.length()+1; i++) {
                char c = actual.charAt(i);
                if(i==0) {
                    assertThat(c).isEqualTo('a');
                }
                if(i==1) {
                    assertThat(c).isEqualTo('b');
                }
                if(i==2) {
                    assertThat(c).isEqualTo('c');
                }
            }
        }).withMessage("String index out of range: 3");
    }
}
