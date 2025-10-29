package study;

import org.junit.jupiter.api.Test;
import study2.Calculator;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorMainTest {

    Calculator calc = new Calculator();

    @Test
    void testAdd() {
        assertEquals(5, calc.add(2,3));
    }

    @Test
    void testSubtraction() {
        assertEquals(1, calc.subtraction(3,2));
    }

    @Test
    void testMultiplication() {
        assertEquals(6, calc.multiplication(2,3));
    }

    @Test
    void testDivision() {
        assertEquals(2, calc.division(6,3));
    }

}