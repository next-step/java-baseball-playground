package stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator;

    @Test
    void add() {
        int result = getResult("1 + 4");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void minus() {
        int result = getResult("1 - 4");
        assertThat(result).isEqualTo(-3);
    }

    @Test
    void multiple() {
        int result = getResult("5 * 4");
        assertThat(result).isEqualTo(20);
    }

    @Test
    void divide() {
        int result = getResult("5 / 4");
        assertThat(result).isEqualTo(1);
    }

    private int getResult(String input) {
        calculator = new Calculator(input);
        return calculator.calculate();
    }

}
