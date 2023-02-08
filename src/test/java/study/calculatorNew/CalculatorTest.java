package study.calculatorNew;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    CalculatorNew calculatorNew;

    @Test
    @DisplayName("정상적으로 add의 값이 동일한지 확인")
    void add() {
        calculatorNew = new CalculatorNew(new AddStrategy());
        assertThat(calculatorNew.returnResult(1,3)).isEqualTo(4);
    }

    @Test
    @DisplayName("정상적으로 곱의 값이 동일한지 확인")
    void mut() {
        calculatorNew = new CalculatorNew(new MultipleStategy());
        assertThat(calculatorNew.returnResult(1,3)).isEqualTo(4);
    }

}
