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
    @DisplayName("요구사항1")
    public void req1(){
        String str = "1,2";
        String[] strSplit = str.split(",");
        assertThat(strSplit).contains("1", "2");

        str = "1";
        strSplit = str.split(",");

        assertThat(strSplit).containsExactly("1");
    }
}
