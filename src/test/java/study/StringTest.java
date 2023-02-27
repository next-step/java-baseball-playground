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
    void splitStringRequirement01() {

        String[] actual01 = "1,2".split(",");
        assertThat(actual01).contains("1","2");
        assertThat(actual01).containsExactly("1","2");

        String[] actual02 = "1".split(",");
        assertThat(actual02).contains("1");
        assertThat(actual02).containsExactly("1");

    }

    @Test
    void splitStringRequirement02() {

        String s = "(1,2)";
        String actual = s.substring(0,s.length()-1);
        assertThat(actual).contains("1","2");

    }

    @Test
    @DisplayName("인덱스 범위 밖 조회 IndexOutOfBoundsException 발생")
    void splitStringRequirement03() {

        String s = "abc";

        assertThatThrownBy(()->{

            s.charAt(4);

        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");

    }

}
