package study.calculator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CalculatorTest {
    private Calculator calculator;
    private Expression expression;

    @ParameterizedTest
    @DisplayName("입력받은 문자열을 연산한다.")
    @ValueSource(strings = "1 + 2 * 3 / 2 * 14")
    void calculate(String input) {
        expression = new Expression(input);
        Double result = calculator.calculate(expression.splitByBlank());
        assertThat(result).isEqualTo(4.5);
    }

    @ParameterizedTest
    @DisplayName("0으로 나눌 수 없다.")
    @ValueSource(strings = "1 + 2 * 3 / 0")
    void divisionByZero(String input) {
        Throwable thrown = catchThrowable(() -> {
            expression = new Expression(input);
            calculator.calculate(expression.splitByBlank());
        });
        assertThat(thrown)
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("/ by zero");
    }
}
