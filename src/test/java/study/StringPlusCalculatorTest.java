package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringPlusCalculatorTest {

    private StringPlusCalculator calculator = new StringPlusCalculator();
    
    @DisplayName("null 또는 빈문자열 테스트")
    @Test
    void nullOrEmptyTest(){
        String numbers = "";
        assertThat(calculator.calculate(numbers)).isEqualTo(0);

        numbers = null;
        assertThat(calculator.calculate(numbers)).isEqualTo(0);
    }

    @DisplayName("숫자 하나 계산 테스트")
    @Test
    void singleFactorTest(){
        String number = "1";
        assertThat(calculator.calculate(number)).isEqualTo(1);
    }

    @DisplayName("쉼표 구분자 테스트")
    @Test
    void commaSeparatorTest(){
        String number = "//,\n1,2,3";
        assertThat(calculator.calculate(number)).isEqualTo(6);
    }

    @DisplayName("콤마,세미클론 구분자 테스트")
    @Test
    void commaAndSemicolonTest(){
        String number = "1,2:3";
        assertThat(calculator.calculate(number)).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자 테스트")
    @Test
    void customSeparatorTest(){
        String number = "//'\n1'2'3";
        assertThat(calculator.calculate(number)).isEqualTo(6);
    }

    @DisplayName("음수 값 전달하는 경우 RuntimeExceptionTest")
    @Test
    void minusExceptionTest(){
        String number = "-1,2,3";
            assertThatThrownBy(()->{
                calculator.calculate(number);
            }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("숫자 외 값 전달하는 경우")
    @Test
    void notNumberFactorExceptionTest(){
        String number = "#,2,3";
        assertThatThrownBy(()->{
            calculator.calculate(number);
        }).isInstanceOf(RuntimeException.class);
    }
}

