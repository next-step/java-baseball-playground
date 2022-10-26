package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @Test
    void stringCalculatorTest1() {
        StringCalculator stringCalculator = new StringCalculator("2 + 3 * 4 / 2");
        assertThat(stringCalculator.getResult()).isEqualTo(10);
    }

    @Test
    void stringCalculatorTest2() {
        StringCalculator stringCalculator = new StringCalculator("2 + 3 + 2 + 1 + 6 + 2 + 1 + 3 / 4");
        assertThat(stringCalculator.getResult()).isEqualTo(5);
    }
}