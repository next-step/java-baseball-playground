package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUP(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    //Test Case 구현
    @Test
    @DisplayName("Set 사이즈 확인")
    void setSize(){
        System.out.println(numbers.size());
    }

    //요구 사항2
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains(int element){
        assertThat(numbers.contains(element)).isTrue();
    }
    //요구 사항 3
    @DisplayName("true, false 값을 같이 리턴한다")
    @ParameterizedTest
    @CsvSource(value = {"1: true","2: true","3: true","4: false","5: false"}, delimiter = ':')
    void set_contains_true_false(int element, boolean expected){
        assertThat(numbers.contains(element)).isEqualTo(expected);
    }
}

