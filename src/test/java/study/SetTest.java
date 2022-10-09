package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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
    //요구사항 1
    @Test
    void setSize(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    //요구사항 2
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains(int nums) {
        assertThat(numbers.contains(nums)).isTrue();
    }

    //요구사항 3
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"},delimiter = ':')
    void containsNumberForTrueFalse(int nums, boolean expected){
        assertThat(numbers.contains(nums)).isEqualTo(expected);
    }
}