package stringCalculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @AfterEach
    void tearDown() {
        stringCalculator = null;
    }

    @Test
    void run() {
        String case1 = stringCalculator.runWithoutUserInput("2 + 3 * 4 / 2");
        String case2 = stringCalculator.runWithoutUserInput("1 + 2 - 3 * 4");
        String case3 = stringCalculator.runWithoutUserInput("2 * 4 / 2 * 4");

        assertThat(case1).isEqualTo("10");
        assertThat(case2).isEqualTo("0");
        assertThat(case3).isEqualTo("16");
    }
}