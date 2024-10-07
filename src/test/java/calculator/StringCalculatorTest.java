package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void beforeEach() {
        calculator = new StringCalculator(new Scanner(System.in));
    }

    @Test
    public void calculatorResult() {
        String input = "2 + 3 * 4 / 2";
        final int result = calculator.calculatorResult(input);

        Assertions.assertThat(result).isEqualTo(10);
    }
    @Test
    public void calculatorResult2() {
        String input = "5 * 8 / 4 + 5 * 2";
        final int result = calculator.calculatorResult(input);

        Assertions.assertThat(result).isEqualTo(30);
    }

    @Test
    public void calculatorResult_fail_wrong_operator() {
        String input = "2 + 3 * 4 ! 5";

        assertThrows(IllegalArgumentException.class, () -> calculator.calculatorResult(input));
    }

    @Test
    public void calculatorResult_fail_wrong_parameter() {
        String input = "2 + 3 * 4 ! j";

        assertThrows(IllegalArgumentException.class, () -> calculator.calculatorResult(input));
    }
}