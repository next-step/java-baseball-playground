package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {
    StringCalculator sc = new StringCalculator();

    @Test
    @DisplayName("문자열 계산기가 잘 작동하는지 확인합니다.")
    void calculate() {
        // Given
        String input = "1 + 9 * 10 / 2";

        // When
        int expected = 50;

        // Then
        Assertions.assertThat(sc.calculate(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("다른 연산자가 주어졌을 때, 예외를 발생시키는지 확인합니다")
    void calculateException() {
        // Given
        String input = "10 ; 5 - 1";

        // Then
        assertThatThrownBy(() -> sc.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연산자");

    }
}