package Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    @Test
    void calculateTest() {
        int result = calculator.calculate(new String[]{"2", "+", "3", "*", "4", "/", "2"});
        assertThat(result).isEqualTo(10);
    }
    @Test
    void 공백문자_2개_이상_일_때_예외테스트() {
        assertThatThrownBy(() -> {
            calculator.calculate("2 + 3  * 4   / 2".split(" "));
        }).isInstanceOf(NumberFormatException.class);
    }
}
