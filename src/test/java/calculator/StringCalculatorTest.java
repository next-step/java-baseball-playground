package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator calculator = new StringCalculator();

    @Test
    @DisplayName("덧셈 테스트")
    void plusTest() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void subtractTest() {
        assertEquals(10, calculator.subtract(20, 10));
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divisionTest() {
        assertEquals(10, calculator.divide(20, 2));
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiplyTest() {
        assertEquals(10, calculator.multiply(5, 2));
    }

    @ParameterizedTest
    @ValueSource(strings = {"#", "$"})
    void partCalculatePermittedOperatorTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            assertEquals(10, calculator.partCalculate(input, 5, "5"));
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    void partCalculateNullInputTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            assertEquals(10, calculator.partCalculate("+", 5, input));
        });
    }
}