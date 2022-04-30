package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    //TODO 입력값 중 숫자와 부호를 구분하는 메소드

    //TODO 사칙연산 메소드

    StringCalculator stringCalculator;

    @BeforeEach
    void setCalculator() {
        this.stringCalculator = new StringCalculator(new Calculator());
    }

    @Test
    void 문자열계산기_테스트() {
        //given
        String[] testValue = new String[] {"2","+","3","*","4","/","1","+","5","-","5","2"};
        //when
        int result = stringCalculator.calculate(testValue);
        //then
        assertThat(result).isEqualTo(20);
    }

}
