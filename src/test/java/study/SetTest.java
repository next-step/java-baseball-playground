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

    @DisplayName("요구사항 1: size()를 통해 Set의 크기를 확인")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("요구사항 2: contains()로 존재하는지 확인")
    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("요구사항 2: 중복없이 contains로 확인")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void containsNoRepeat(Integer input) {
        Assertions.assertTrue(numbers.contains(input));
    }

    @DisplayName("요구사항 3: contains가 False인 경우 확인")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true","4,false", "5,false"})
    void containsFalse(Integer input, Boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
