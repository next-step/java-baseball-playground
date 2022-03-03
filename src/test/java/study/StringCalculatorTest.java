package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    private StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("정상 입력시 의도대로 계산된 값이 나오는지 테스트")
    @Test
    void calculateTest() {
        String[] formula = new Formula("5 + 5 * 5 / 25").splitFormula();
        int result = stringCalculator.calculateFormula(formula);
        assertThat(2).isEqualTo(result);
    }

    @DisplayName("0으로  나눌 시 IllegalArgumentException이 발생하는지 테스트")
    @Test
    void devideZeroTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String[] formula = new Formula("2 + 2 * 10 / 0").splitFormula();
            stringCalculator.calculateFormula(formula);
        });
    }

    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException이 발생하는지 테스트")
    @Test
    void inputNullOrEmptySet() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String[] formula = new Formula("2 +   * 2 / 2").splitFormula();
            stringCalculator.calculateFormula(formula);
        });
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    @Test
    void checkPermittedOperator() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String[] formula = new Formula("2 $ 6 * 5 / 4").splitFormula();
            stringCalculator.calculateFormula(formula);
        });
    }

    @DisplayName("Operaotr plus 연산 테스트")
    @Test
    void operatorPlusTest() {
        assertThat(Operator.PLUS.operate(1, 5)).isEqualTo(6);
    }

    @DisplayName("Operator minus 연산 테스트")
    @Test
    void operatorMinusTest() {
        assertThat(Operator.MINUS.operate(9, 3)).isEqualTo(6);
    }

    @DisplayName("Opertor multiply 연산 테스트")
    @Test
    void operatorMultiplyTest() {
        assertThat(Operator.MULTIPLY.operate(2, 4)).isEqualTo(8);
    }

    @DisplayName("Operator divide 연산 테스트")
    @Test
    void operatorDevideTest() {
        assertThat(Operator.DEVIDE.operate(16 , 2)).isEqualTo(8);
    }
}
