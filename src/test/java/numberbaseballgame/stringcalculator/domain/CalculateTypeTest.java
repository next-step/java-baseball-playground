package numberbaseballgame.stringcalculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculateTypeTest {

    @DisplayName("enum타입의 사칙연산 값을 확인한다")
    @Test
    void calculate() {
        assertThat(CalculateType.PLUS.calculate(1, 2)).isEqualTo(3);
        assertThat(CalculateType.MINUS.calculate(1, 2)).isEqualTo(-1);
        assertThat(CalculateType.TIMES.calculate(1, 2)).isEqualTo(2);
        assertThat(CalculateType.DIVIED_BY.calculate(1, 2)).isEqualTo(0);
    }

    @DisplayName("주어진 문자열(+)이 어떤 사칙연산인지 찾아준다")
    @Test
    void fromPlusSymbol() {
        String operationSymbol = "+";
        assertThat(CalculateType.fromSymbol(operationSymbol)).isEqualTo(CalculateType.PLUS);
    }

    @DisplayName("주어진 문자열(-)이 어떤 사칙연산인지 찾아준다")
    @Test
    void fromMinusSymbol() {
        String operationSymbol = "-";
        assertThat(CalculateType.fromSymbol(operationSymbol)).isEqualTo(CalculateType.MINUS);
    }

    @DisplayName("주어진 문자열(*)이 어떤 사칙연산인지 찾아준다")
    @Test
    void fromTimesSymbol() {
        String operationSymbol = "*";
        assertThat(CalculateType.fromSymbol(operationSymbol)).isEqualTo(CalculateType.TIMES);
    }

    @DisplayName("주어진 문자열(/)이 어떤 사칙연산인지 찾아준다")
    @Test
    void fromDivideBySymbol() {
        String operationSymbol = "/";
        assertThat(CalculateType.fromSymbol(operationSymbol)).isEqualTo(CalculateType.DIVIED_BY);
    }

    @DisplayName("주어진 문자열이 연산기호가 아닐때 예외처리 해준다")
    @Test
    void testException() {
        String actual = "&";
        assertThatThrownBy(() -> {
            CalculateType.fromSymbol(actual);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid operation symbol: &");
    }
}