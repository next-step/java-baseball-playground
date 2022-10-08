package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    public static final String DELIMITER = " ";

    @DisplayName("사용자가 올바른 입력을 수행한 경우 계산기는 정상적으로 수행됩니다")
    @Test
    public void test(){
        // given
        UserInputReceiver userInputReceiver = new UserInputReceiver();
        userInputReceiver.receive("2 + 8", DELIMITER);

        Calculator calculator = new Calculator(userInputReceiver);

        // when
        int result = calculator.calculate();

        // then
        assertThat(result).isEqualTo(10);
    }
}