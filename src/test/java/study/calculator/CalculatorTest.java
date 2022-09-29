package study.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    /*@Test
    @DisplayName("일단 만들어 놓기")
    void thisIsTest() throws Exception{
    Calculator cal = new Calculator();

    org.assertj.core.api.Assertions.assertThat(cal.calculator("2 + 3 + 4 * 5")).isEqualTo(45);
    }
    @Test
    @DisplayName("문자 우선일 경우?")
    void thisIsTest2() {
         Calculator cal = new Calculator();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> cal.calculator("+ 3 + 4 * 5"));
    }
    @Test
    @DisplayName("문자 우선일 경우?")
    void thisIsTest3() {
         Calculator cal = new Calculator();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> cal.calculator("3 +4 * 5"));
    }*/
    @Test
    @DisplayName("불변객체 변경 데이터 최소화")
    void test1() throws Exception{
        Calculator result = Calculator.isCalculaor("2 5 3 * 4");
        Assertions.assertThat(result.getResult()).isEqualTo(60);
        System.out.println("result = " + result.getResult());
    }

}
