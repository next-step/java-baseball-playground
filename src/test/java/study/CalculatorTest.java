package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    void plusTest() throws Exception {
        int result = calculator.StringCalculator("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void minusTest() throws Exception {
        int result = calculator.StringCalculator("6 - 3");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void multiplicationTest() throws Exception {
        int result = calculator.StringCalculator("5 * 3");
        assertThat(result).isEqualTo(15);
    }

    @Test
    void divisionTest() throws Exception {
        int result = calculator.StringCalculator("6 / 3");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void stringCalculatorTest() throws Exception {
        int result = calculator.StringCalculator("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);

    }

    @Test
    void inputTest() {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> {
                    calculator.StringCalculator("+ 1 3");
                });
    }

    @Test
    void operationExceptionTest() {
        assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> {
                    calculator.OperationCalculator(1, "$", 2);
                }).withMessageContaining("잘못 입력하셨습니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void nullTest(String input) {
        assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> {
                    calculator.StringCalculator(input);
                });
    }


}
