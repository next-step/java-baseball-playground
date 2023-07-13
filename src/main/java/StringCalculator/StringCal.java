package StringCalculator;

import java.util.*;

public class StringCal {
    public static String inputExpression () {
        return (new Scanner(System.in)).nextLine();
    }

    public static String [] splitExpression(String expression) {
        String [] values = expression.split(" ");
        return values;
    }

    public static float castingFloat(String value) {
        return Float.parseFloat(value);
    }
    public static int castingInt(String value) {
        return Integer.parseInt(value);
    }
    public static float calculator (String [] values, float calculationResult) {
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals("+")) {
                int nextTerm = castingInt(values[i+1]);
                calculationResult = plus(calculationResult, nextTerm);
            }
            if (values[i].equals("-")) {
                int nextTerm = castingInt(values[i+1]);
                calculationResult = minus(calculationResult, nextTerm);
            }
            if (values[i].equals("/")) {
                int nextTerm = castingInt(values[i+1]);
                calculationResult = divide(calculationResult, nextTerm);
            }
            if (values[i].equals("*")) {
                int nextTerm = castingInt(values[i+1]);
                calculationResult = multiply(calculationResult, nextTerm);
            }
        }
        return calculationResult;
    }
    public static float plus (float calculationResult , int nextTerm) {
        return calculationResult+nextTerm;
    }

    public static float minus (float calculationResult , int nextTerm) {
        return calculationResult-nextTerm;
    }

    public static float divide (float calculationResult , int nextTerm) {
        return (float)calculationResult/nextTerm;
    }

    public static float multiply (float calculationResult , int nextTerm) {
        return calculationResult*nextTerm;
    }
    public static void main(String[] args) {
        System.out.println("식을 입력하세요");
        String value = inputExpression();
        String [] values = splitExpression(value);
        float firstValue = castingFloat(values[0]);
        float answer = calculator(values, firstValue);
        System.out.println(answer);
    }
}
