package calculator;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import calculator.Calculator;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @DisplayName("연산자 확인 메소드 테스트")
    @ParameterizedTest
    @CsvSource(value = {"+:1", "-:2", "*:3", "/:4", "=:0"}, delimiter = ':')
    public void checkOperatorTest(String input, int expected) {
        assertThat(calculator.checkOperator(input)).isEqualTo(expected);
    }

    @DisplayName("계산 메소드 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:1:2:3", "2:2:4:-2", "4:3:3:12", "6:4:3:2", "%,3,2,^"}, delimiter = ':')
    public void calculatingTest(int result, int operator, int operand, int expected) {
        assertThat(calculator.calculating(result, operator, operand)).isEqualTo(expected);
    }

}