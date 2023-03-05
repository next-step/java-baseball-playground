package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    // Test Case 구현

    @Test
    @DisplayName("set 의 사이즈 반환")
    void size() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }


    @ParameterizedTest
    @DisplayName("set 내부 value 확인하기")
    @ValueSource(ints = {1, 2, 3})
    void contains(int nums) {
        assertTrue(numbers.contains(nums));
    }


    @ParameterizedTest
    @DisplayName("set 내부 value 확인하기 / 없는 경우 false")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void valueCheck(int input, boolean expected) {
        boolean isContains = numbers.contains(input);
        assertEquals(isContains, expected);
    }

}
