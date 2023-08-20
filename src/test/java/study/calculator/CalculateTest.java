package study.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.calculator.Calculator;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CalculateTest {
    @ParameterizedTest
    @ValueSource(strings = {
            "1 + 1 - 2 / 0",
            "5 * 3 / 0"})
    void notDivisibleBy0(String formula) {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> {
                    Calculator.calculate(formula);
                }).withMessageMatching("0으로 나누기 불가");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1 + 1 - 0 / 2",
            "3 - 5 "})
    void calculateTest (String formula) {
        assertThatCode(() -> Calculator.calculate(formula))
         .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("correctArgs")
    void calculateByStringOrder(String formula, int result) {
        assertThat(Calculator.calculate(formula))
                .isEqualTo(result);
    }

    static Stream<Arguments> correctArgs() {
        return Stream.of(
                Arguments.arguments("3 - 1 * 10", 20),
                Arguments.arguments("80 + 4 / 2 + 5", 47),
                Arguments.arguments("3 + 9 * 3", 36)
        );
    }
}
