import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperatorTest {

    @Test
    @DisplayName("연산자는 덧셈을 할 수 있습니다.")
    void plus() {
        // given // when
        String expression = "1 + 3";
        // then
        assertThat(Operator.PLUS.function(1.0, 3.0)).isEqualTo(1 + 3);
    }

    @Test
    @DisplayName("연산자는 뺄셈을 할 수 있습니다.")
    void minus() {
        // given // when
        String expression = "1 - 3";
        // then
        assertThat(Operator.MINUS.function(1.0, 3.0)).isEqualTo(1 - 3);
    }

    @Test
    @DisplayName("연산자는 곱셈을 할 수 있습니다.")
    void multiply() {
        // given // when
        String expression = "1 * 3";
        // then
        assertThat(Operator.MULTIPLY.function(1.0, 3.0)).isEqualTo(1 * 3);
    }

    @Test
    @DisplayName("연산자는 나눗셈을 할 수 있습니다.")
    void divide() {
        // given // when
        String expression = "1 / 3";
        // then
        assertThat(Operator.DIVIDE.function(1.0, 3.0)).isEqualTo(1.0 / 3.0);
    }

    @Test
    @DisplayName("연산자는 0으로 나눌 수 없습니다.")
    void divideFail() {
        // given // when
        String expression = "1 / 0";
        // then
        assertThatThrownBy(() -> Operator.DIVIDE.function(1.0, 0.0))
            .isInstanceOf(ArithmeticException.class)
            .hasMessage("0으로 나눌 수 없습니다.");
    }

}