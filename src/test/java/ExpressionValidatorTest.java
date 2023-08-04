import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class ExpressionValidatorTest {

    @Test
    @DisplayName("수식 판별기는 수식이 올바른지 판단할 수 있다.")
    void valid(){
        // given // when
        ExpressionValidator validator = new ExpressionValidator();
//        String expression = "2 () 3";
        String expression = "2 * 2 *";

        // then
        assertThatThrownBy(() -> validator.valid(expression))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("수식이 올바르지 않습니다");

    }

}