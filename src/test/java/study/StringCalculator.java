package study;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class StringCalculator {
    private String[] values;
    @BeforeAll
    void setUp() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        values = value.split(" ");
    }

    @Test
    int calculate()
    {
        int number = Integer.parseInt(values[0]);
        for(int i = 1; i < values.length; i++)
        {
            if(i % 2 == 1)
            {
                if()
            }
        }
    }
}
