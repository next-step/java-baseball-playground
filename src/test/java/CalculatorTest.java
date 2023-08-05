import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class CalculatorTest {

    @Test
    @DisplayName("계산기는 수식을 받아 계산을 할 수 있다.")
    void calculate(){
        // given
        ExpressionValidator validator = new ExpressionValidator();
        ExpressionInformer informer = new ExpressionInformer();
        Calculator calculator = new Calculator(validator, informer);
        String expression = "2.0 + 3.0 * 5.1 / 3.2";

        // when
        Double answer = calculator.calculate(expression);

        // then
        Double expected = 2.0 + 3.0 * 5.1 / 3.2;
        assertThat(answer).isEqualTo((2.0 + 3.0) * 5.1 / 3.2);
    }


}