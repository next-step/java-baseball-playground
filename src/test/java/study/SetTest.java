package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    @DisplayName("Set 크기 확인")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("1, 2, 3 포함 확인")
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    /*
        JUnit 5 Parameterized 문서 참고
        https://www.baeldung.com/parameterized-tests-junit-5
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains_ParameterizedTest_ValueSource(int num) {
        assertThat(numbers.contains(num)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false"})
    void contains_ParameterizedTest_CsvSource(int num, boolean expected) {
        assertThat(numbers.contains(num)).isEqualTo(expected);
    }

    /*
        Assert J 문서 참고
        https://www.baeldung.com/introduction-to-assertj
     */
}
