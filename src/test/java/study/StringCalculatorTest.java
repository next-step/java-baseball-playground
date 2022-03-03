package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    StringCalculator calculator;

    @BeforeEach
    void setCalculator() {
        this.calculator = new StringCalculator();
    }

    @ParameterizedTest
    @ValueSource(strings = "2 + 2 3 * 4 / 2")
    void 문자열_분리_테스트(String value) {
        assertArrayEquals(new String[]{"2", "+", "3", "*", "4", "/", "2"}, calculator.spaceSplit(value));
    }





}
