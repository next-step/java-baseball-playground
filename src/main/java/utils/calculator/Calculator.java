package utils.calculator;

import java.util.Scanner;

public class Calculator {

    public static int calculate(String formula) {
        final String[] values = formula.split(" ");
        int result = Integer.parseInt(values[0]);
        String operator = "";
        int number = 0;

        for(int i=1 ; i<values.length ; i++)  {
            if(i%2 != 0) {
                operator = values[i];
                continue;
            }

            number =  Integer.parseInt(values[i]);
            if(operator.equals("+")) {
                result += number;
            } else if(operator.equals("-")) {
                result -= number;
            } else if(operator.equals("*")) {
                result *= number;
            } else if(operator.equals("/")) {
                if (number==0) {
                    throw new ArithmeticException("0으로 나누기 불가");
                }
                result /= Integer.parseInt(values[i]);
            }
        }

        return result;
    }

}
