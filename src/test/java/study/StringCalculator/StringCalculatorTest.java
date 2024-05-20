package study.StringCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    /*
        요구사항
        - 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
        - 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
        - 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
     */

    private StringCalculator stringCalculator;

    @BeforeEach
    public void setUp() {
        stringCalculator = new StringCalculatorImpl();
    }

    @Test
    @DisplayName("정상 케이스")
    void calculate_success_test() {
        final String given = "2 + 3 * 4 / 2";

        int result = stringCalculator.calculator(given);
        assertEquals(10, result);
    }

    @Test
    @DisplayName("마지막 피연산자 입력하지 않은 경우")
    void calculate_fail_notContainOperand() {
        final String given = "2 + 3 * 4 / ";

        assertThatThrownBy(() -> stringCalculator.calculator(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid input");
    }

    @Test
    @DisplayName("숫자, 연산자 외에 다른 문자열 입력한 경우")
    void calculate_fail_containInvalidString() {
        final String given = "2 + 3 * $ / ";

        assertThatThrownBy(() -> stringCalculator.calculator(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid");
    }

    @Test
    @DisplayName("피연산자 연속으로 입력한 경우")
    void calculate_fail_consecutiveOperand() {
        final String given = "2 2 3 * 4 / 2";

        assertThatThrownBy(() -> stringCalculator.calculator(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid operator: ");
    }

    @Test
    @DisplayName("연산자 연속으로 입력한 경우")
    void calculate_fail_consecutiveOperator() {
        final String given = "2 + + * 4 / 2";

        assertThatThrownBy(() -> stringCalculator.calculator(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid operand: ");
    }

}