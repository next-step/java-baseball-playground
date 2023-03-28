package study;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Logger
public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split(){
        String[] number1 = "1,2".split(",");
        assertThat(number1).contains("2", "1"); // 순서 상관없이
        assertThat(number1).containsExactly("1", "2"); // 순서까지 일치
        System.out.println("number1 배열 = " + Arrays.toString(number1));

        String[] number2 = "1".split(",");
        assertThat(number2).contains("1");
        assertThat(number2).containsExactly("1");
        System.out.println("number2 배열 = " + Arrays.toString(number2));
    }

    @Test
    void substring(){
        String str = "(1,2)".substring(1,4);
        assertThat(str).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생")
    void charAt(){
        String str = "abc";
        try {
        char charTest = str.charAt(3);
        }
        catch (StringIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

}
    class SetTest {
        private Set<Integer> numbers;

        @BeforeEach
        void setUp() {
            numbers = new HashSet<>();
            numbers.add(1);
            numbers.add(1);
            numbers.add(2);
            numbers.add(3);
        }

        @Test
        void setSize(){
            System.out.println("set size = "+numbers.size());
        }

        @Test
        void contains() {
            assertThat(numbers.contains(1)).isTrue();
            assertThat(numbers.contains(2)).isTrue();
            assertThat(numbers.contains(3)).isTrue();
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        void setNumberTest(int number) {
            assertTrue(numbers.contains(number)); // numbers Set배열에 1, 2, 3 순서대로 add
        }
    }
