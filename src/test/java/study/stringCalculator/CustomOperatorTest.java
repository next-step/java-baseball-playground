package study.stringCalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CustomOperatorTest {

    private final CustomOperator customOperator = new CustomOperator();


    @ParameterizedTest
    @CsvSource(value = {"1, +, 1, 2",
                        "2, -, 1, 1",
                        "3, *, 2, 6",
                        "3, /, 3, 1"})
    @DisplayName("올바른 식을 넣으면 연산이 성공해야 한다.")
    void test(String first, String op, String second, String result) {
        Number firstNumber = Number.from(first);
        Number secondNumber = Number.from(second);
        Number resultNumber = Number.from(result);

        Number actualNumber = customOperator.doOperation(firstNumber, op, secondNumber);

        Assertions.assertThat(actualNumber).isEqualTo(resultNumber);
    }

    @Test
    @DisplayName("0으로 나눌 시 예외가 발생한다.")
    void test2() {
        Number firstNumber = Number.from("2");
        Number secondNumber = Number.from("0");

        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
                () -> customOperator.doOperation(firstNumber, "/", secondNumber));
    }
}