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

    @Test
    @DisplayName("요구사항 1. 사이즈 확인")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("요구사항 2. set 내용물 확인")
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest(name = "{0} test")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항 2. 리팩토링 ParameterizeTest 사용")
    void containsWithParameterizedTest(Integer input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest(name = "{0} test")
    @DisplayName("요구사항 3. 입력값에 따라 결과 값이 다른 경우 테스트")
    @CsvSource(value = {"0:false", "1:true", "2:true", "3:true"}, delimiter = ':')
    void containsWithiParameterizedTestAntCsvSource(Integer input, Boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}
