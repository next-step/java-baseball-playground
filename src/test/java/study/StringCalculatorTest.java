package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    private StringCalculator stringCalculator = new StringCalculator();

    @Test
    void plusTest() {
        assertEquals(5, stringCalculator.plus(2, "3"));
        assertThat(stringCalculator.plus(2, "3")).isEqualTo(5);
    }

    @Test
    void minusTest() {
        assertEquals(7, stringCalculator.minus(10, "3"));
        assertThat(stringCalculator.minus(10, "3")).isEqualTo(7);
    }

    @Test
    void multiplyTest() {
        assertEquals(10, stringCalculator.multiply(2, "5"));
        assertThat(stringCalculator.multiply(2, "5")).isEqualTo(10);
    }

    @Test
    void divisionTest() {
        assertEquals(10, stringCalculator.division(20, "2"));
        assertThat(stringCalculator.division(20, "2")).isEqualTo(10);
    }

    @Test
    void calculateTest() {
        assertEquals(10, stringCalculator.calculate("2 + 3 * 4 / 2"));
        assertThat(stringCalculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"#", "$", "&", "!", "@", "%", "^"})
    void partCalculatePermittedOperatorTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            assertEquals(10, stringCalculator.partCalculate(input, 5, "5"));
            assertThat(stringCalculator.partCalculate(input, 5, "5")).isEqualTo(10);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    void partCalculateNullInputTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            assertEquals(10, stringCalculator.partCalculate("+", 5, input));
            assertThat(stringCalculator.partCalculate("+", 5, input)).isEqualTo(10);
        });
    }
}
