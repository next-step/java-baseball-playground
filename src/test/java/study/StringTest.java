package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    @Test
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1","2");
    }
    @Test
    void detailedSplit() {
        String[] actual = "1,".split(",");
        assertThat(actual).containsExactly("1");
    }
    @Test
    void substringTest() {
        String actual = "(1,2)";
        //actual = actual.replace(" ","");
        actual = actual.substring(1,actual.length()-1);
        assertThat(actual).isEqualTo("1,2");
    }
    @Nested
    @DisplayName("charAt 테스트")
    class charAtTest {
        String actual = "abc";
        @Test
        void 무난() {
            assertThat(actual.charAt(1)).isEqualTo('b');
        }
        @Test
        void 예외() {
            assertThatThrownBy(()-> {
                actual.charAt(5);
            }).isInstanceOf(IndexOutOfBoundsException.class)
                    .hasMessageContaining("index out of range");
        }
        @Test
        void 예외2() {
            assertThatExceptionOfType(IndexOutOfBoundsException.class)
                    .isThrownBy(()-> {
                        actual.charAt(4);
                    }).withMessageMatching("String index out of range: 4");
        }
    }
}
