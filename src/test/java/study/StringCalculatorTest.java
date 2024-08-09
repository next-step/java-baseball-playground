package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    StringCalculator cal;

    @BeforeEach
    public void setUp()  {
        cal = new StringCalculator();
    }

    @Test
    public void add()  {
        assertEquals(7, cal.add(3, 4));
    }

    @Test
    public void subtract()  {
        assertEquals(1, cal.subtract(5,  4));
    }

    @Test
    public void multiply()  {
        assertEquals(6, cal.multiply(2, 3));
    }

    @Test
    public void divide()  {
        assertEquals(2, cal.divide(8, 4));
    }

    @Test void calc() {
        int result = cal.transform(cal.split("2 + 3 * 4 / 2"));
        assertEquals(10, result);
    }

    @AfterEach
    public void tearDown() {
        cal = null;
    }
}