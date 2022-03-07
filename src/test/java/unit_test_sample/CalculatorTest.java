package unit_test_sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator cal;

    @BeforeEach
    public void setUp(){
        cal = new Calculator();
    }


    @Test
    public void 덧셈(){
        assertEquals(10, cal.add(5, 5));
    }


    @Test
    public void 뺄셈(){
        assertEquals(5, cal.subtract(7, 2));
    }


    @Test
    public void 나눗셈(){
        assertEquals(10, cal.divide(100, 10));
    }

    @Test
    public void 곱셈(){
        assertEquals(50, cal.multiply(10, 5));
    }



    @AfterEach
    public void tearDown(){
        cal = null;
    }




}