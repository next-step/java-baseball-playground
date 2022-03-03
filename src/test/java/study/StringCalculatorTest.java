package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    private StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("정상 입력시 의도대로 계산된 값이 나오는지 테스트")
    @Test
    void calculateTest() {
        int result = stringCalculator.calculateFormula(new Formula("5 + 5 * 5 / 25").getFormula());
        assertThat(2).isEqualTo(result);
    }

    @DisplayName("0으로  나눌 시 IllegalArgumentException이 발생하는지 테스트")
    @Test
    void devideZeroTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.calculateFormula(new Formula("2 + 2 * 10 / 0").getFormula());
        });
    }

    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException이 발생하는지 테스트")
    @Test
    void inputNullOrEmptySet() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.calculateFormula(new Formula("2 +   * 2 / 2").getFormula());
        });
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    @Test
    void checkPermittedOperator() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.calculateFormula(new Formula("2 $ 6 * 5 / 4").getFormula());
        });
    }


}
