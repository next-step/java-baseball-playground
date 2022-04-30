package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        assertTrue( true, "setup");
    }

    @Test
    public void test1() {
        assertTrue( false, "test1");
    }

    @Test
    public void 부호와_숫자를_입력받고_계산하는_메소드_테스트() {
        //given
        int a = 5;
        int b = 6;
        String sign = "+";
        //when
        int result = calculator.calc(a, b, sign);
        //then
        assertThat(result).isEqualTo(11);
    }


    @AfterEach
    public void tearDown() {
        assertTrue( true, "tearDown");
    }



}
