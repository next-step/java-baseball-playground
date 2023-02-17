package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("더하기")
    void add() {
        assertThat(calculator.add(1,2)).isEqualTo(3);
    }

    @Test
    @DisplayName("빼기")
    void subtract() {
        assertThat(calculator.subtract(2,1)).isEqualTo(1);
    }

    @Test
    @DisplayName("곱하기")
    void multiply() {
        assertThat(calculator.multiply(2,3)).isEqualTo(6);
    }

    @Test
    @DisplayName("나누기")
    void divide() {
        assertThat(calculator.divide(10,2)).isEqualTo(5);

        assertThatThrownBy(()->calculator.divide(2,0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자열 계산")
    void calculate(){
        assertThat(calculator.calculate("5 + 3 * 2 / 0")).isEqualTo(8);
    }
}