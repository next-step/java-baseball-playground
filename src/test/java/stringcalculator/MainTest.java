package stringcalculator;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MainTest {
    @Test
    public void testCalculateResult() {
        String input = "5 + 3 * 2"; // 예시 입력
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        int result = Main.calculateResult();

        assertEquals(16, result);
    }

    @Test
    public void isOperator() {
        assertFalse(Main.isOperator("#"));
    }

}