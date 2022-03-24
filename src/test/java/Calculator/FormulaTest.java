package Calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FormulaTest {

    @Test
    void FormulaConstructorTest() {
        Formula formula = new Formula("2 + 3 * 4 / 2");
        assertThat(formula.getFormula()).isEqualTo("2 + 3 * 4 / 2".split(" "));
    }
}
