package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.Locale;

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
        //given
        String[] testValue = new String[] {"2","+","3","*","4","/","2"};
        //when
        Integer[] result = calculator.findNumerics(testValue);
        //then
        assertArrayEquals(new Integer[]{2,3,4,2},result);
    }

    @Test
    void 사칙연산_테스트_덧셈() {
        //given
        int testValue1 = 2;
        int testValue2 = 4;
        //when
        int result = calculator.add(testValue1, testValue2);
        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 사칙연산_테스트_뺄셈() {
        //given
        int testValue1 = 5;
        int testValue2 = 4;
        //when
        int result = calculator.subtract(testValue1, testValue2);
        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 사칙연산_테스트_곱셈() {
        //given
        int testValue1 = 3;
        int testValue2 = 4;
        //when
        int result = calculator.multiply(testValue1, testValue2);
        //then
        assertThat(result).isEqualTo(12);
    }

    @Test
    void 사칙연산_테스트_나눗셈() {
        //given
        int testValue1 = 20;
        int testValue2 = 4;
        //when
        int result = calculator.divide(testValue1, testValue2);
        //then
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 문자열계산기_테스트() {
        //given
        String[] testValue = new String[] {"2","+","3","*","4","/","1","+","5"};
        Integer[] numerics = calculator.findNumerics(testValue);
        String[] signs = {"+", "*", "/","+"};

        //when
        int result = calculator.calucate(numerics, signs);

        //then
        assertThat(result).isEqualTo(25);
    }

}
