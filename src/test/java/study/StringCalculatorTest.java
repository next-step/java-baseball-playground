package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    private StringCalculator calc;

    @BeforeEach
    void setUp() {
        calc = new StringCalculator();
    }

    @Test
    @DisplayName("간단한 이항식 문자열을 정상적으로 계산하는지 확인한다")
    void calculateSimpleFormula() {
        int expected = 5;
        int actual = calc.calculate(2, "+", 3);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("지원하지 않는 연산자를 전달할 때 예외를 발생하는지 확인한다")
    void throwExceptionWhenNotSupportedOperatorPassed() {
        assertThatThrownBy(() -> {
            int actual = calc.calculate(2, "!", 3);
        }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0으로 나누는 값을 전달할 때 예외를 발생하는지 확인한다")
    void throwExceptionWhenDividedByZero() {
        assertThatThrownBy(() -> {
            int actual = calc.calculate(2, "/", 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
