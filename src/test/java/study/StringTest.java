package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("요구사항1")
    void split() {
        String[] actual1 = "1,2".split(",");
        assertThat(actual1).hasSize(2);
        assertThat(actual1[0]).isEqualTo("1");
        assertThat(actual1[1]).isEqualTo("2");
        //hint
        assertThat(actual1).containsExactly("1","2");

        String[] actual2 = "1".split(",");
        assertThat(actual2).hasSize(1);
        assertThat(actual2[0]).isEqualTo("1");
        //hint
        assertThat(actual2).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2")
    void substring() {
        String actual = "(1,2)".substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3 - 문자열에서 특정위치의 문자를 가져온다.")
    void charAtTest() {
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
        assertThatThrownBy(()-> str.charAt(3))
            .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
