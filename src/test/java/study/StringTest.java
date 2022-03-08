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
        String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1","2");
        actual = "1".split(",");
        assertThat(actual).contains("1");
    }

    @Test
    void substring(){
        String actual = "(1,2)";
        actual = actual.substring(actual.indexOf("(")+1, actual.indexOf(")")-1);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void charAt(){
        
    }
}
