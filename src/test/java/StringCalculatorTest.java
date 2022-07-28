import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import string_calculator.StringCalculator;

import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class StringCalculatorTest {

    StringCalculator calculator;

    String validInput;
    String invalidInput1;
    String invalidInput2;
    String invalidInput3;

    @BeforeEach
    @DisplayName("input 세팅")
    void set_input() {
        validInput = "2 + 3 * 4 / 2";
        invalidInput1 = "2 2 2 * 3";
        invalidInput2 = "2 + * 3 * 3";
        invalidInput3 = "2 d * 3 *";
    }

    @Test
    void verifyLastStringTest() {
        assertThatThrownBy(() -> {
            calculator = new StringCalculator(invalidInput3);
            calculator.verifyLastString();
        }).isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("입력값");
    }

    @Test
    void verifyContinuityNumTest() {
        assertThatThrownBy(() -> {
            calculator = new StringCalculator(invalidInput1);
            calculator.processCalc();
        }).isInstanceOf(InvalidParameterException.class)
                .hasMessageContaining("숫자가 연속으로 사용");
    }

    @Test
    void verifyContinuityOperTest() {
        assertThatThrownBy(() -> {
            calculator = new StringCalculator(invalidInput2);
            calculator.processCalc();
        }).isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("연산자가 연속으로 사용");
    }

    @Test
    void validInputTest() throws Exception {
        calculator = new StringCalculator(validInput);
        calculator.verifyLastString();
        int result = calculator.processCalc();

        assertThat(result).isEqualTo(10);
    }
}