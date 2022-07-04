package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.StringCalculator.ScannerUtil;

public class StringCalculatorTest {
    private StringCalculator calc;

    @BeforeEach
    void setUp() {
        calc = new StringCalculator();
    }

    @Test
    @DisplayName("간단한 이항식 문자열을 정상적으로 계산하는지 확인한다")
    void calculateSimpleFormula() {
        int expected = 5;
        int actual = calc.calculateSimple(2, "+", 3);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("지원하지 않는 연산자를 전달할 때 예외를 발생하는지 확인한다")
    void throwExceptionWhenNotSupportedOperatorPassed() {
        assertThatThrownBy(() -> {
            int actual = calc.calculateSimple(2, "!", 3);
        }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0으로 나누는 값을 전달할 때 예외를 발생하는지 확인한다")
    void throwExceptionWhenDividedByZero() {
        assertThatThrownBy(() -> {
            int actual = calc.calculateSimple(2, "/", 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    class FakeScanner implements ScannerUtil {

        String value;
        FakeScanner(String input) {
            value = input;
        }
        @Override
        public String nextLine() {
            return value;
        }
    }

    void makeStringCalculatorWithFakeScanner(String userInput) {
        FakeScanner fakeScanner = new FakeScanner(userInput);
        calc.setScanner(fakeScanner);
    }

    @Test
    @DisplayName("사용자로부터 계산식을 입력받기를 확인한다")
    void inputFormula() {
        String expected = "2 + 3 * 5 / 3";
        makeStringCalculatorWithFakeScanner(expected);

        String actual = calc.inputFormula();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("문자열 계산식을 빈칸으로 쪼갠 계산 배열을 확인한다")
    void splitFormula() {
        String expected = "2 + 3 * 5 / 3";
        makeStringCalculatorWithFakeScanner(expected);
        String formula = calc.inputFormula();

        String[] actualUnits = calc.splitFormula(formula);

        assertThat(actualUnits).contains("2");
        assertThat(actualUnits).contains("+");
        assertThat(actualUnits).contains("3");
        assertThat(actualUnits).contains("*");
        assertThat(actualUnits).contains("5");
        assertThat(actualUnits).contains("/");
        assertThat(actualUnits).contains("3");
    }

    @Test
    @DisplayName("문자열 계산식을 연산자 우선순위 무사한 순서대로 계산한 결과를 확인한다")
    void calculateFormulaWithIgnoringOperatorOrder() {
        String fakeInput = "2 + 3 * 5 / 3";
        int expected = 8;
        makeStringCalculatorWithFakeScanner(fakeInput);
        String formula = calc.inputFormula();
        String[] actualUnits = calc.splitFormula(formula);

        int actual = calc.calculate(actualUnits);

        assertThat(actual).isEqualTo(expected);
    }
}
