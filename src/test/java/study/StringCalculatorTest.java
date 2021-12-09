package study;

import StringCalculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    @DisplayName("의도한 값이 나오는지 확인")
    void getRightResultTest() {
        String str = "2 + 3 * 4 / 2";
        assertThat(calculator.getResult(str)).isEqualTo(10);
    }

    @ParameterizedTest
    @DisplayName("문자열을 배열로 올바르게 바꾸는지 확인")
    @ValueSource(strings = {"2", "+", "3"})
    void fromInputToArrayTest(String input) {
        String inputString = "2 + 3";
        assertThat(inputString.contains(input)).isTrue();
    }

    @Test
    @DisplayName("0으로 나누는 시도가 있을 시 Arithmetic Exception 나오는지 확인")
    void divideByZeroTest() {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> {
                    calculator.getArithmeticResult('/', 2, 0);
                });
    }

    @Test
    @DisplayName("input이 empty 혹은 null일 시 IllegalArgumentException 나오는지 확인")
    void inputEmptyOrNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.getResult(" ");
        });
    }
}