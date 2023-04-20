package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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
    /**
     * 요구사항 1 : size()
     */
    @Test
    void size_test() {
        // given

        // when
        int result = numbers.size();

        // then
        assertThat(result).isEqualTo(3);
    }
    /**
     * 요구사항 2 : contains()
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains_test(int input) {
        // given
        // when
        // then
        assertThat(numbers.contains(input)).isTrue();
    }
    /**
     * 요구사항 3 : contains()
     */
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains_test(int input, boolean result) {
        // given
        // when
        // then
        assertThat(numbers.contains(input)).isEqualTo(result);
    }
}
