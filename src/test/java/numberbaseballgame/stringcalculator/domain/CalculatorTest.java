package numberbaseballgame.stringcalculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @DisplayName("문자열을 입력하고 공백을 기준으로 나눴을 때, 계산을 한다")
    @Test
    void performCalculate() {
        UserInputReader userInputReader = new UserInputReader();
        userInputReader.splitBy("1 + 3 * 2", " ");

        Calculator calculator = new Calculator(userInputReader);
        Assertions.assertThat(calculator.performCalculate()).isEqualTo(8);
    }
}