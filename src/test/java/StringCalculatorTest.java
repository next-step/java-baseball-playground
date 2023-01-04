import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    StringCalculator calc;

    @BeforeEach
    void setUp() {
        calc = new StringCalculator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"2+3*4/2", "2 + 3 * 4 /", "+ 3 * 4 / 2", "+ 3 * 4 /", "2 k 3 * 4 / 2"})
    @DisplayName("잘못된 계산식")
    void incorrectFormula(String formula) {
        setInputStream(formula);
        assertThatThrownBy(() -> calc.calculate())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("잘못된 계산식입니다.");
    }

    @Test
    @DisplayName("0으로 나누기")
    void divisionBy0() {
        setInputStream("2 + 3 * 4 / 0");
        assertThatThrownBy(() -> calc.calculate())
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("0으로 나눌 수 없습니다.");
    }

    @Test
    void calculate() {
        setInputStream(" 2 + 3 * 4 / 2");

        int actual = calc.calculate();
        assertThat(actual).isEqualTo(10);
    }

    private void setInputStream(String formula) {
        InputStream in = new ByteArrayInputStream(formula.getBytes());
        System.setIn(in);
    }
}
