package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalcTest {

    private StringCalc calc;

    @BeforeEach
    public void before() {
        calc = new StringCalc();
    }

    @ParameterizedTest
    @DisplayName("계산기 단위 테스트")
    @CsvSource(value = {"1 + 2", "2 + 5", "4 + 8"})
    void calcplus (String input, int expected) {
        assertThat(calc.equals("+")).isEqualTo(expected);
    }
}
