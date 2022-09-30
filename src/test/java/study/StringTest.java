package study;

import org.junit.jupiter.api.DisplayName;
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
    @Test
    @DisplayName("특정 위치 문자 가져오기: assertJ_Using the String.valueOf() Method")
    void getCharAsAStringValueOfAssertJ(){
        String charAtVar1 = String.valueOf("abc".charAt(1));
        assertThat(charAtVar1).isEqualTo("b");
    }
    @Test
    @DisplayName("특정 위치 문자 가져오기: assertJ_Using the Character.toString() Method")
    void getCharAsACharacterToStringAssertJ(){
        String charAtVar2 = Character.toString("abc".charAt(0));
        assertThat(charAtVar2).isEqualTo("a");
    }
    @Test
    @DisplayName("특정 위치 문자 가져오기: JUnit_Using the String.valueOf()_and_Character.toString() Method")
    void getCharAsAStringValueOfAndCharacterToStringJUnit(){
        String charAtVar3 = "abc";
        assertEquals("b", String.valueOf(charAtVar3.charAt(1)));
        assertEquals("a", Character.toString(charAtVar3.charAt(0)));
    }
//    @Test
//    @DisplayName("특정 위치 문자 가져오기 has")
//    void charGetFromString1() {
//        int index = 2;
//        String charAtVar4 = String.valueOf("abc".charAt(index));
//
//        assertThatThrownBy(() -> throw new charAtVar(null)
//        ).isInstanceOf(IndexOutOfBoundsException.class)
//                .hasMessageContaining("%d", index);
//    }
}