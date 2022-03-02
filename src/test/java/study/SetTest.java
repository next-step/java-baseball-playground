package study;

import org.junit.jupiter.api.Assertions;
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
    @DisplayName("numbers size 구하기")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("numbers Set이 포함하고 있는 값 구하기")
    void contain() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("ParameterizedTest를 활용하여 중복코드 제거하기 - true return")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void parameterizedTest(Integer number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("ParameterizedTest를 활용하여 중복코드 제거하기2 - true false return")
    @ParameterizedTest(name = "{index} {displayName} flag={0} delimiterString={1}")
    @CsvSource(value = {"true:1", "true:2", "true:3", "false:4", "false:5"}, delimiterString = ":")
    void parameterizedCsvTest(Boolean expected, Integer element) {
        assertEquals(numbers.contains(expected), element);
    }

}
