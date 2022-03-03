package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
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
