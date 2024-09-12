package study;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

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

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void set의_요소가_123(int number) {
        // then
        assertTrue(numbers.contains(number));
    }

//    // 왜 이런겨
//    @ParameterizedTest
//    @ValueSource(strings = {"", "  "})
//    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
//        assertTrue(Strings.isNullOrEmpty(input));
//    }

    @ParameterizedTest
    @CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
        String actual = input.toLowerCase();
        assertEquals(expected, actual);
    }
}
