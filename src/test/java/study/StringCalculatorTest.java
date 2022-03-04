package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    //TODO 입력값 중 숫자와 부호를 구분하는 메소드

    //TODO 사칙연산 메소드

    StringCalculator calculator;

    @BeforeEach
    void setCalculator() {
        this.calculator = new StringCalculator();
    }

    @ParameterizedTest
    @ValueSource(strings = "2 + 3 * 4 / 2")
    void 문자열_분리_테스트(String value) {
        assertArrayEquals(new String[]{"2", "+", "3", "*", "4", "/", "2"}, calculator.split(value, " "));
    }

    @Test
    void 전체값에서_숫자만_리턴_테스트() {
        String[] testValue = new String[] {"2","+","3","*","4","/","2"};
        assertArrayEquals(new int[]{2,3,4,2},calculator.findNumerics(testValue));
    }

    @Test
    void 사칙연산_테스트_덧셈() {
        assertThat(calculator.add("2", "4")).isEqualTo(6);
    }

    @Test
    void 사칙연산_테스트_뺄셈() {
        assertThat(calculator.subtract("5", "4")).isEqualTo(1);
    }

    @Test
    void 사칙연산_테스트_곱셈() {
        assertThat(calculator.multiply("3", "4")).isEqualTo(12);
    }

    @Test
    void 사칙연산_테스트_나눗셈() {
        assertThat(calculator.divide("20", "4")).isEqualTo(5);
    }






}
