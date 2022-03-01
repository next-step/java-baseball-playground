package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    private StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 발생 하는지 테스트")
    @Test
    void inputNullOrEmptyTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String formula = "2 +  * 2 / 2";
            stringCalculator.setFormula(formula);
            stringCalculator.calculateFormula();
        });
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    @Test
    void checkPermittedOperator() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String formula = "2 $ 6 * 5 / 4";
            stringCalculator.setFormula(formula);
            stringCalculator.calculateFormula();
        });
    }



}
