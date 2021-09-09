package me.hjhng125.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @Test
    @DisplayName("2로 나눈 나머지가 0인 경우 테스트")
    void divideBy2() {
        assertThat(0 % 2).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("입력값이 주어졌을 때 정상적으로 값을 반환하는지 테스트")
    @CsvSource(value = {"2 + 3 * 4 / 2 : 10.0", "30 - 7 : 23", "5 : 5"}, delimiter = ':')
    void calculate(String expression, double expected) {
        calculator = new StringCalculator(expression);

        double calculate = calculator.calculate();
        assertThat(calculate).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("null이 주어졌을 때 정상적으로 값을 반환하는지 테스트")
    @NullSource
    void calculateNull(String expression) {
        assertThatThrownBy(() -> {
            calculator = new StringCalculator(expression);
            calculator.calculate();
        })
            .isInstanceOf(NullPointerException.class)
            .hasMessageContaining("\"String.split(String)\" because \"this.expression\" is null");
    }

    @ParameterizedTest
    @DisplayName("빈 문자열이 주어졌을 때 정상적으로 값을 반환하는지 테스트")
    @EmptySource
    void calculateEmpty(String expression) {
        assertThatThrownBy(() -> {
            calculator = new StringCalculator(expression);
            calculator.calculate();
        })
            .isInstanceOfAny(IllegalAccessError.class);
    }
}
