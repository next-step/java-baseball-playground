package study;

import org.junit.jupiter.api.DisplayName;
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
        String [] actual = "1,2".split(",");
        assertThat(actual).contains("1","2");
        assertThat(actual).containsExactly("1","2");
    }
    @Test
    void remove() {
        String actual = "(1,2)".substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }
    @DisplayName("charAt범위테스트")
    @Test
    public void testException() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(()->{
            int i = 3;
            char actual = "abc".charAt(i);
        }).withMessage("String index 범위를 벗어났습니다.");

    }

}
