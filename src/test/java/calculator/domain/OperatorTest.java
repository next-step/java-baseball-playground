package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @DisplayName("클라이언트가 존재하는 심볼을 찾는 경우 일치하는 Operator를 반환합니다.")
    @Test
    void test_FindBySymbol_when_normalInput_returnMatchedOperatorInstance() {
        // given
        String symbol = "+";

        // when
        Operator result = Operator.findBySymbol(symbol);

        // then
        assertThat(result).isEqualTo(Operator.PLUS);
    }

    @DisplayName("클라이언트가 존재하는 심볼을 찾는 경우 일치하는 Operator를 반환합니다.")
    @Test
    void test_FindBySymbol_when_wrongInput_throwIllegalArgumentException() {
        // given
        String symbol = "*";

        // when & then
        assertThatThrownBy(() -> Operator.findBySymbol(symbol))
                .isInstanceOf(IllegalArgumentException.class);
    }
}