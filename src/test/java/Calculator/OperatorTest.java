package Calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorTest {

    @Test
    void plusTest() {
        assertThat(Operator.isPlus().operate(6, "2")).isEqualTo(8);
    }

    @Test
    void minusTest() {
        assertThat(Operator.isMinus().operate(6, "2")).isEqualTo(4);
    }

    @Test
    void multiplyTest() {
        assertThat(Operator.isMultiply().operate(6, "2")).isEqualTo(12);
    }

    @Test
    void devideTest() {
        assertThat(Operator.isDevide().operate(6, "2")).isEqualTo(3);
    }

    @Test
    @DisplayName("0으로 나눌 때 예외 처리")
    void devideZeroTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator.isDevide().operate(6, "0");
        });
    }

    @Test
    @DisplayName("올바른 사칙연산을 입력했을 때 테스트")
    void findByOperatorTest() {
        Operator operator = Operator.findByOperator("+");
        assertThat(operator).isEqualTo(Operator.isPlus());
        operator = Operator.findByOperator("-");
        assertThat(operator).isEqualTo(Operator.isMinus());
        operator = Operator.findByOperator("*");
        assertThat(operator).isEqualTo(Operator.isMultiply());
        operator = Operator.findByOperator("/");
        assertThat(operator).isEqualTo(Operator.isDevide());
    }

    @Test
    void 사칙연산_이외의_문자를_입력했을_때_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            if(Operator.findByOperator("$") == null) {
                 throw new IllegalArgumentException();
            }
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"+, 8", "-, 4", "*, 12", "/, 3"}, delimiter = ',')
    void 사칙연산_한번에_테스트하기(String value, String result) {
        assertThat(Operator.findByOperator(value).operate(6, "2"))
                .isEqualTo(Integer.parseInt(result));
    }

}
