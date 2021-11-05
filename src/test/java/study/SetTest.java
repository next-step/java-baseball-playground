package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

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
    @Test
    @DisplayName("Set 의 크기 확인")
    void setSizePrint() {
        System.out.println("numbers.size = " + numbers.size());
    }

    @Test
    @DisplayName("set 내부 원소 확인")
    void setElementCheck() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("set 내부 원소 확인 - 중복 코드 제거(ParameterizedTest 사용)")
    void setElementCheck2(int i) {
        assertThat(numbers.contains(i)).isTrue();
    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(2, true),
                Arguments.of(3, true),
                Arguments.of(4, false),
                Arguments.of(5, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    @DisplayName("")
    void setElementCheck3(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
