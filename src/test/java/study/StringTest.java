package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    private Set<Integer> numbers;

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void test1A() {
        String actual = "1,2";
        String[] actual1 = actual.split(",");

        assertThat(actual1[0]).contains("1");

    }

    @Test
    void test1B() {
        String actual = "1";
        String[] actual1 = actual.split(",");

        assertThat(actual1).containsExactly("1");
    }

    @Test
    void test2() {
        String actual = "(1,2)";
        String actual1 = actual.substring(1,4);

        assertThat(actual1).isEqualTo("1,2");
    }

    @Test
    void test3() {
        String actual = "abc";
        char a = actual.charAt(1);

        assertThat(a).isEqualTo('b');
    }

    @Test
    @BeforeEach
    void test4A() {

        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void test4B(int number) {

        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

//        assertThat(numbers.contains(1)).isTrue();
//        assertThat(numbers.contains(2)).isTrue();
//        assertThat(numbers.contains(3)).isTrue();

        assertThat(numbers.contains(number)).isTrue();
    }

    // TODO
//    @ParameterizedTest
//    @CsvSource(value = {"7", "4", "5"})
//    void test4C(int number) {
//
//        numbers = new HashSet<>();
//        numbers.add(1);
//        numbers.add(1);
//        numbers.add(2);
//        numbers.add(3);
//
//        asser
//    }
}
