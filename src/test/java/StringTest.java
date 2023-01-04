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
        String[] arr = "1,2".split(",");
        assertThat(arr).containsExactly("1", "2");

        arr = "1".split(",");
        assertThat(arr).contains("1");
    }

    @Test
    void substring() {
        String str = "(1,2)";
        String result = str.substring(1, str.length()-1);
        assertThat(result).isEqualTo("1,2");
    }
}
