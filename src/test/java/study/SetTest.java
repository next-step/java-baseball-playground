package study;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeEach;
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

    // Test Case 구현


    @Test
    void checkSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void isContains_ShouldReturnTrueForContainsNumber(int input) {
        assertTrue(isContains(input));
    }

    private boolean isContains(int input) {
        return numbers.contains(input);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false", "5:false"}, delimiter = ':')
    void a(int input, boolean expected){
        assertEquals(isContains(input), expected);
    }

}
