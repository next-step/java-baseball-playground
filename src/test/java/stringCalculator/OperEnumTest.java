package stringCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class OperEnumTest {

    @Test
    void of() {
        assertThat(OperEnum.of("+")).isEqualTo(OperEnum.PLUS);
        assertThat(OperEnum.of("-")).isEqualTo(OperEnum.MINUS);
        assertThat(OperEnum.of("*")).isEqualTo(OperEnum.MULTIPLE);
        assertThat(OperEnum.of("/")).isEqualTo(OperEnum.DIVIDE);
    }
}
