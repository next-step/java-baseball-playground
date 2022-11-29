package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


// @ author ninaaano
public class StringCalculatorTest {
    StringCalculator cal;

    @BeforeEach
    public void setUp()  {
        cal = new StringCalculator();
    }

    @Test
    public void 덧셈()  {
        assertEquals(7, cal.add(3, 4));
    }

    @Test
    public void 뺄셈()  {
        assertEquals(1, cal.subtract(5,  4));
    }

    @Test
    public void 곱셉()  {
        assertEquals(6, cal.multiply(2, 3));
    }

    @Test
    public void 나눗셈()  {
        assertEquals(2, cal.divide(8, 4));
    }

    public void 문자열나누기(){
        String test = "1+2";
        String[] result = {"1","+","2"};
        assertThat(result).isEqualTo(cal.separate(test));
    }

    @AfterEach
    public void tearDown() {
        cal = null;
    }

    @Test
    void stringConverter() {
        String test = "1a";
        int test2 = 1;
        assertThat(test2).isEqualTo(cal.stringConverter(test));
    }

    @Test
    void separate() {
        String test = "1 + 2";
        String[] result = {"1","+","2"};
        assertThat(result).isEqualTo(cal.separate(test));
    }

    @Test
    void calculator() throws Exception {
        int temp = 1;
        String temp2 = "*";
        int temp3 = 2;
        int result = 2;
        assertThat(result).isEqualTo(cal.calculator(temp,temp2,temp3));
    }

//    @Test
//    public void add(){
//        assertThat(5).isEqualTo(.add(1,4));
//    }
}
