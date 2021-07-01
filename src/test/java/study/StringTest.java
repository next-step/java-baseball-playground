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

    @DisplayName("splitByComma")
    @Test
    void split() {
        //split returns an Array of Strings not Strings
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1");
        assertThat(actual).contains("2");
    }

    @DisplayName("splitByComma2")
    @Test
    void splitSingle() {
        //split returns an Array of Strings not Strings
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @DisplayName("splitNoParenthesis")
    @Test
    void splitNoParenthesis() {
        //split returns an Array of Strings not Strings
        //contains exactly for an Array, isEqualTo or Equals  for String
        String input = "(1,2)";
        Strings strings = new Strings();
        String actual = strings.splitNoParenthesis(input);
        assertThat(actual).isEqualTo("1,2");
    }
}
