package study;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    @Test
    void split(){
        String[] splitVar = "1,2".split(",");
        assertThat(splitVar).contains("1", "2");

        splitVar = "1".split(",");
        assertThat(splitVar).containsExactly("1");
    }
}