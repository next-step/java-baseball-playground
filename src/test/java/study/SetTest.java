package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private static Set<Integer> numbers;

    @BeforeAll
    static void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
    }

    @Test
    @DisplayName("Set의 크기 확인 테스트")
    void getSize() {
        assertThat(numbers.size()).isEqualTo(4);
    }

    @DisplayName("Set의 contains 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void contains(int number) {
        assertTrue(numbers.contains(number));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:true", "5:false"}, delimiter = ':')
    void ifContains(String input, String expected) {
        assertEquals(Boolean.parseBoolean(expected),
            numbers.contains(Integer.parseInt(input)));
    }
}
