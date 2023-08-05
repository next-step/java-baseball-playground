import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperatorTest {

    @Test
    @DisplayName("연산자는 연산을 할 수 있습니다.")
    void function() {
        // given // when
        String expression = "1 + 3";
        // then
        assertThat(Operator.PLUS.function(1.0, 3.0)).isEqualTo(4);
    }

}