package study.test0;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // 요구사항1
    @Test
    void 요구사항1(){
        System.out.println(numbers.size());
        assertThat(numbers.size());
    }


    // 요구사항2
    @Test
    void 요구사항2(){
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();

    }
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int arguments){
        assertThat(numbers.equals(arguments));
    }

    // 요구사항3
    @ParameterizedTest
    @CsvSource(value = {"[1, 2, 3]:[4, 5]"}, delimiter = ':')
    void 요구사항3(String input, String expected){
        String a = numbers.toString();

        assertEquals(a, input);
    }
}

