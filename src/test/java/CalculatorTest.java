import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void calcNum() {
        String expression = "2 + 3 * 4 / 2";
        calculator.setArray(expression);

        assertThat(calculator.calcNum()).isEqualTo(10);
    }

    @Test
    void selectType() {
    }
}