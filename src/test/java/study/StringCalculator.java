package study;

import java.util.Arrays;
import java.util.Scanner;


public class StringCalculator {

    public int executeCalculator() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String[] values = value.split(" ");

        int sum = Integer.parseInt(values[0]);

        String tempOperator = "";
        for (int i=1; i<values.length; i++) {
            if (_isOperator(values[i])) {
                tempOperator= values[i];
            } else {
                sum = _calculate(sum, Integer.parseInt(values[i]), tempOperator);
            }
        }
        return sum;
    }

    private boolean _isOperator(String val) {
        String[] operators = {"+", "-", "*", "/"};
        return Arrays.asList(operators).contains(val);
    }

    private int _calculate(int n1, int n2, String operator) {
        switch (operator) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "/":
                return n1 / n2;
            default:
                return 0;
        }
    }

}
