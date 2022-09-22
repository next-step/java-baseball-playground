package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    @Test
    @DisplayName("assertJ_Using the String.valueOf() Method")
    void getCharAsAStringValueOfAssertJ(){
        String charAtVar1 = String.valueOf("abc".charAt(1));
        assertThat(charAtVar1).isEqualTo("b");
    }
    @Test
    @DisplayName("assertJ_Using the Character.toString() Method")
    void getCharAsACharacterToStringAssertJ(){
        String charAtVar2 = Character.toString("abc".charAt(0));
        assertThat(charAtVar2).isEqualTo("a");
    }
    @Test
    @DisplayName("JUnit_Using the String.valueOf()_and_Character.toString() Method")
    void getCharAsAStringValueOfAndCharacterToStringJUnit(){
        String sample = "abc";
        assertEquals("b", String.valueOf(sample.charAt(1)));
        assertEquals("a", Character.toString(sample.charAt(0)));
        assertThrows(IndexOutOfBoundsException.class, () -> sample.charAt(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> sample.charAt(sample.length()));
    }
}