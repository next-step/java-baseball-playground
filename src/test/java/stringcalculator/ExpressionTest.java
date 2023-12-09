package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ExpressionTest {

    @Test
    void testExpression() {
        Expression expression = new Expression("5+3*2");

        String[] result = expression.getExpression();
        String[] expected = {"5", "+", "3", "*", "2"};

        assertArrayEquals(expected, result);
    }
}