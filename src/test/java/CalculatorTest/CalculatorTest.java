package CalculatorTest;

import calculator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("전체 calculator 테스트")
    void testStringCalculator() {
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @DisplayName("연산자 메서드 테스트")
    @ParameterizedTest
    @CsvSource(value = {"+:10:2:12", "-:10:2:8", "*:10:2:20", "/:10:2:5"}, delimiter = ':')
    void testOperator(String op, int num1, int num2, int result) {
        assertThat(calculator.operateResult(op,num1,num2)).isEqualTo(result);
    }

    @Test
    @DisplayName("+ test")
    void testAdd() {
        assertThat(calculator.add(1,2)).isEqualTo(3);
    }

    @Test
    @DisplayName("- test")
    void testSubstract() {
        assertThat(calculator.substract(1,2)).isEqualTo(-1);
    }

    @Test
    @DisplayName("* test")
    void testMultiply() {
        assertThat(calculator.multiply(3,2)).isEqualTo(6);
    }

    @Test
    @DisplayName("/ test")
    void testDivide() {
        assertThat(calculator.divide(8,2)).isEqualTo(4);
    }
}
