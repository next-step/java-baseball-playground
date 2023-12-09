package stringcalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class OperatorTest {

    @Test
    public void operateAdd() {
        assertEquals(5, Operator.operate(2, "+", 3));
    }

    @Test
    public void operateSub() {
        assertEquals(2, Operator.operate(5, "-", 3));
    }

    @Test
    public void operateMul() {
        assertEquals(15, Operator.operate(3, "*", 5));
    }

    @Test
    public void operateDiv() {
        assertEquals(2, Operator.operate(6, "/", 3));
    }

    @Test
    public void isOperator() {
        assertFalse(Operator.isOperator("#"));
    }

}