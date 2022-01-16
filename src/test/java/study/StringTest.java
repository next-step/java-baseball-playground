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
    void split() {
        String[] str = "1,2".split(",");
        assertThat(str).contains("1","2");

        str = "1,".split(",");
        assertThat(str).containsExactly("1");
    }

    @Test
    void substring() {
        String str = "(1,2)".substring(1,4).substring(0,3);
        assertThat(str).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정위치의 문자열 가져오기")
    void getCharactr() {

        String str = "abc";

        assertThatThrownBy(() -> str.charAt(str.length()))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");

    }


}
