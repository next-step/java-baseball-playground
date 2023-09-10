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
    void split1() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1", "2");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void split2() {
        String[] actual = "1".split(",");
        assertThat(actual).contains("1");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 학습 테스트")
    void charAt1() {
        char actual = "abc".charAt(0);
        assertThat(actual).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt() StringIndexOutOfBoundsException")
    void charAt2() {
        assertThatThrownBy(() -> {
            char actual = "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
