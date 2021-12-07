package StringCalculator;

import java.util.Objects;

public class Calculator {
    public String[] fromInputToArray(String input) {
        String[] arrayValue = input.split(" ");
        return arrayValue;
    }

    public int fromStringToInt(String str) {
        return Integer.parseInt(str);
    }

    public int getArithmeticResult(char operator, int leftValue, int rightValue) {
        if (operator == '+') {
            return leftValue + rightValue;
        }
        if (operator == '-') {
            return leftValue - rightValue;
        }
        if (operator == '*') {
            return leftValue * rightValue;
        }
        if (operator == '/') {
            try {
                return leftValue / rightValue;
            } catch (ArithmeticException e) {
                System.out.println("0으로 나눌 수 없습니다.");
            }
            throw new ArithmeticException();
        }
        throw new IllegalArgumentException();
    }

    public int calculateInOrder(String[] str) {
        int result = fromStringToInt(str[0]);
        for (int i = 1; i < str.length; i += 2) {
            result = getArithmeticResult(str[i].charAt(0), result, fromStringToInt(str[i+1]));
        }
        return result;
    }

    public boolean judgeEmptyOrNull(String input) {
        return Objects.equals(input, " ");
    }

    public int getResult(String input) {
        if (judgeEmptyOrNull(input)) {
            throw new IllegalArgumentException();
        }
        return calculateInOrder(fromInputToArray(input));
    }
}
