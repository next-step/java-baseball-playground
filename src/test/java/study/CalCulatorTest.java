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
        int result = calculate(values);

        //then
        Assertions.assertEquals(result,10);

    }

    private static int calculate(String[] values) {

        int leftHandSide = Integer.parseInt(values[0]);

        int result = leftHandSide ;

        for(int i = 1; i< values.length-1; i+=2){

            int rightHandSide = Integer.parseInt(values[i +1]);

            result = calcluateValue(values[i], result, rightHandSide);

        }

        return result;
    }

    private static int calcluateValue(String operator, int leftHandSide, int rightHandSide) {

        switch (operator){

            case "+":

                return leftHandSide + rightHandSide;

            case "-":

                return leftHandSide - rightHandSide;

            case "*":

                return leftHandSide * rightHandSide;

            case "/":

                if (rightHandSide == 0) {

                    throw new ArithmeticException("0으로 나눌 수 없습니다.");

                }

                return leftHandSide / rightHandSide;
            default:

                throw new IllegalArgumentException("잘못된 연산자입니다.");

        }
    }
}
