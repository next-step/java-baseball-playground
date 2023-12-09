package stringcalculator;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ResultTest {
    @Test
    public void testCalculateResult() {
        String input = "5-2*4";
        Input.scan = new Scanner(input);

        int result = Result.calculateResult();

        assertEquals(12, result);
    }
}