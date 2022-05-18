package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    @DisplayName("일단 만들어 놓기")
    void thisIsTest() throws Exception{
    Calculator cal = new Calculator();

    int a = cal.calculator("2 + 3 + 4 * 5");
        System.out.println(a);
    }
}
