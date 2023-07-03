package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String str = "1,2";
        String[] split = str.split(",");
        System.out.println(split[0]);
        assertThat(split[0]).isEqualTo("1");
        assertThat(split[1]).isEqualTo("2");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException")
    void substring() {
        String str = "(1,2)";
        String substring = str.substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

}
