package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTest {


    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] strArray = "1,2".split(",");
        assertThat(strArray).contains("1");
        String[] strArray2 = "1,2".split(",");
        assertThat(strArray2).containsExactly("1","2");
    }

    @Test
    void split2() {
        String[] strArray = "1".split(",");
        assertThat(strArray).contains("1");
    }

    @Test
    void subString() {
        String str = "(1,2)";
        System.out.println(str.substring(1,4));
    }

    private Set<Integer> numbers;

    @DisplayName("AssertJ Exception Test")
    @Test
    void charAt(){
        String abc = "abc";
        assertThat(abc.charAt(0)).isEqualTo('a');
        assertThat(abc.charAt(1)).isEqualTo('b');
        assertThat(abc.charAt(2)).isEqualTo('c');

        assertThatThrownBy(()->{
            abc.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("set size() method test")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("contain is true test")
    @Test
    void contain() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void isThereNumbers(int num){
        assertTrue(numbers.contains(num));
    }

    @ParameterizedTest
    @CsvSource({"1,true", "2,true","3,true", "4,false","5,false"})
    void csvSourceTest(Integer num, Boolean expected){
        if(expected){
            assertThat(numbers.contains(num)).isTrue();
            return;
        }
        assertThat(numbers.contains(num)).isFalse();
    }
}
