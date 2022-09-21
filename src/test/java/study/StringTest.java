package study;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void replaceJUnit() {
        String actualJUnit = "abc".replace("b", "d");
        assertEquals(actualJUnit, "adc");
    }

    @Test
    void split() {
        String[] splitVar = "1,2".split(",");
        assertThat(splitVar).contains("1","2");

        splitVar = "1".split(",");
        assertThat(splitVar).containsExactly("1");
    }
    @Test
    void substring(){
        String substringVar = "(1,2)".substring(1,4);
        assertThat(substringVar).isEqualTo("1,2");
    }
}
