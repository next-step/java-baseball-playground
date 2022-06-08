package stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OperatorTest {

    @Test
    void isPlus() {
        Operator operator = new Operator("+");
        assertThat(operator.isPlus()).isTrue();
        assertThat(operator.isMinus()).isFalse();
        assertThat(operator.isMultiple()).isFalse();
        assertThat(operator.isDivide()).isFalse();
    }

    @Test
    void isMinus() {
        Operator operator = new Operator("-");
        assertThat(operator.isPlus()).isFalse();
        assertThat(operator.isMinus()).isTrue();
        assertThat(operator.isMultiple()).isFalse();
        assertThat(operator.isDivide()).isFalse();
    }

    @Test
    void isMultiple() {
        Operator operator = new Operator("*");
        assertThat(operator.isPlus()).isFalse();
        assertThat(operator.isMinus()).isFalse();
        assertThat(operator.isMultiple()).isTrue();
        assertThat(operator.isDivide()).isFalse();
    }

    @Test
    void isDivide() {
        Operator operator = new Operator("/");
        assertThat(operator.isPlus()).isFalse();
        assertThat(operator.isMinus()).isFalse();
        assertThat(operator.isMultiple()).isFalse();
        assertThat(operator.isDivide()).isTrue();
    }
}
