package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringCalculatorTest {

    private StringCalculator sc;

    @BeforeEach
    void setUp() {
        sc = new StringCalculator();
    }

    private static Stream<Arguments> prvideStringToCalculate() {
        return Stream.of(
                Arguments.of("1 + 2", 3),
                Arguments.of("2 + 3", 5),
                Arguments.of("3 - 1", 2),
                Arguments.of("10 * 3", 30),
                Arguments.of("39 / 3 + 5 - 2", 16),
                Arguments.of("39 / 2 + 1", 20.5),
                Arguments.of("39 - 3 / 3 + 4", 16)
        );
    }

    @ParameterizedTest
    @MethodSource("prvideStringToCalculate")
    @DisplayName("복잡한 연산 테스트")
    void complexCalculation(String str, double expected) {
        sc.enter(str);
        sc.calculateAll();
        assertThat(sc.getResult()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 / 0"})
    @DisplayName("0으로 나누기")
    void divideByZero(String str) {
        sc.enter(str);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> sc.calculateAll()
        ).withMessageContaining("0으로 나눌수 없습니다");
    }
}
