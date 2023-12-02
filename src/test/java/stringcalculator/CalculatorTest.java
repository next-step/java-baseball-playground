package stringcalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void add() {
        assertEquals(5, Calculator.add(2, 3));
    }

    @Test
    public void sub() {
        assertEquals(5, Calculator.sub(8, 3));
        assertEquals(-5, Calculator.sub(3, 8));
    }

    @Test
    public void mul() {
        assertEquals(15, Calculator.mul(5, 3));
    }

    @Test
    public void div() {
        assertEquals(5, Calculator.div(15, 3));
    }

    @Test(expected = ArithmeticException.class)
    public void divZeroArithmeticException() {
        Calculator.div(10, 0);
    }
}