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
    void spilt() {
        String[] value = "1,2".split(",");
        assertThat(value).containsExactly("1","2");

        value = "1".split(",");
        assertThat(value).containsExactly("1");
    }

    @Test
    void substring() {
        String value = "(1,2)".substring(1,4);
        assertThat(value).doesNotContain("()");
    }

    @Test
    @DisplayName("charAt() 메소드를 통해 특정 문자 위치 가져올 경우")
    void charAt() {
        char abc = "abc".charAt(0);
        assertThat(abc).isEqualTo('a');
        abc = "abc".charAt(1);
        assertThat(abc).isEqualTo('b');
        abc = "abc".charAt(2);
        assertThat(abc).isEqualTo('c');

        assertThatThrownBy(() -> {
            "abc".charAt(5);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index : 2, size : 2");
    }
}


