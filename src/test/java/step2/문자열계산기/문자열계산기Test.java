package step2.문자열계산기;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class 문자열계산기Test {

    private 문자열계산기 calculator = new 문자열계산기();


    @Test
    void plusTest(){
        assertEquals(5, calculator.plus(2, "3"));
    }

    @Test
    void minusTest(){
        assertEquals(7, calculator.minus(10, "3"));
    }

    @Test
    void multiplyTest(){
        assertEquals(10, calculator.multiply(2, "5"));
    }

    @Test
    void disvisionTest(){
        assertEquals(10, calculator.division(20, "2"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"#", "$"})
    void partCalculatePermittedOperatorTest(String input){
        assertThatIllegalArgumentException().isThrownBy(() ->{
            System.out.println(calculator.parCalculate(input, 5, "5"));
            assertEquals(10, calculator.parCalculate(input, 5, "5"));
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    void partCalculateNullInputTests(String input){
        assertThatIllegalArgumentException().isThrownBy(() ->{
            System.out.println(calculator.parCalculate("+", 5, input));
            assertEquals(10, calculator.parCalculate("+", 5, input));
        });
    }


}