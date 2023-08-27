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
    void split(){
        String actual = "1,2";
        String[] split = actual.split(",");
        assertThat(split).contains("1").contains("2"); // 1
        assertThat(split).containsExactly("1", "2"); // 2
    }

    @Test
    void substring(){
        String actual = "(1,2)";
        String substring = actual.substring(1, actual.length() - 1);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String.charAt 매서드에서 유효하지 않은 인덱스를 인자로 준 경우")
    void charAt(){
        String actual = "abc";
        int idx = 3;
        assertThatThrownBy(() -> {
            actual.charAt(idx);
        })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + idx);;
    }
}
