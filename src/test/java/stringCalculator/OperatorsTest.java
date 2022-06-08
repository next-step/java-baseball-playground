package stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OperatorsTest {
    Operators operators;

    @Test
    void poll() {
        String input = "1 + 4 - 2 * 4 / 2";
        operators = new Operators(input.split(" "));
        assertThat(operators.poll().isPlus()).isTrue();
        assertThat(operators.poll().isMinus()).isTrue();
        assertThat(operators.poll().isMultiple()).isTrue();
        assertThat(operators.poll().isDivide()).isTrue();
    }
}
