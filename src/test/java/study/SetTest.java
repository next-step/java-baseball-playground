package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class SetTest {

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
    void size(){
        assertThat(numbers.size()).isEqualTo(3);
        assertTrue(numbers.size() == 3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int arg) {
        assertThat(numbers.contains(arg)).as("check parameter 'arg'").isTrue();
        assertTrue(numbers.contains(arg));
    }

    @DisplayName("입력 값에 따라 결과 값이 다른 경우에 대한 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5: false"}, delimiter = ':')
    void variousInputContains(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
        assertTrue(numbers.contains(input) == expected);
    }

}

