import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExpressionInformerTest {

    @Test
    @DisplayName("수식전달자는 수식을 연산자에게 전달할 수 있다.")
    void informOperator(){
        // given
        ExpressionValidator validator = new ExpressionValidator();
        ExpressionInformer informer = new ExpressionInformer();
        String expression = "2.0 + 3.0 * 5.1 / 3.2";
        validator.valid(expression);
        // when
        Double actual = informer.InformOperator(expression);
        // then
        assertThat(actual).isEqualTo((2.0 + 3.0) * 5.1 / 3.2);
    }

}