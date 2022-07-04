package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("Set 에서 중복된 요소(1,1,2,3)는 무시하는지 확인한다")
    void checkCardinalitySizeOfSet() {
        assertThat(numbers).contains(1);
        assertThat(numbers).contains(2);
        assertThat(numbers).contains(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("JUnit.ParameterizedTest()를 활용한 중복없는 Set.size()를 확인한다")
    void checkCardinalitySizeOfSetWithParameterizedTest(Integer element) {
        assertThat(numbers).contains(element);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    @DisplayName("ParamerizedTest 의 CsvSource 를 활용한 중복없는 Set.size()를 확인한다")
    void checkCardinalitySizeOfSetWithCsvSourceOfParameterizedTest(Integer element, boolean expected) {
        assertThat(numbers.contains(element)).isEqualTo(expected);
    }
}