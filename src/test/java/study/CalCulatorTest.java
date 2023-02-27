package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class CalCulatorTest {

    Scanner scanner;

    @BeforeEach
    void setup(){

        scanner = new Scanner(System.in);

    }

    @Test
    void test(){

        //given
        //String value = scanner.nextLine();

        String value =  "2 + 3 * 4 / 2";

        String[] values = value.split(" ");

        //when

        int result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length-1; i+=2) {

            int rightHandSide = Integer.parseInt(values[i + 1]);

            switch (values[i]) {
                case "+":
                    result += rightHandSide;
                    break;
                case "-":
                    result -= rightHandSide;
                    break;
                case "*":
                    result *= rightHandSide;
                    break;
                case "/":
                    try {
                        result /= rightHandSide;
                    } catch (ArithmeticException e) {
                        System.out.println("0으로 나눌 수 없습니다.");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("잘못된 연산자입니다.");
            }

        }

        //then
        Assertions.assertEquals(result,10);

    }
}
