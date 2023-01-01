package calculator;

import java.util.Scanner;

public class Calculator {

    private static final String[] permitOperator = {"+", "-", "*", "/"};

    public static int add(int first, int second) {
        return first + second;
    }

    public static int subtract(int first, int second) {
        return first - second;
    }

    public static int multiply(int first, int second) {
        return first * second;
    }

    public static int divide(int first, int second) {
        return first / second;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();

        // inputValues를 계산
        calculate(inputValue);
    }

    private static void calculate(String inputValue) {
        String[] values = inputValue.split(" ");
        int result = Integer.parseInt(values[0]);
        String operator = "";

        for (int i = 0; i < values.length; i++) {
            if (isPermittedOperator(values[i])) {
                operator = values[i];
            } else {
                partCalculate(operator, result, values[i]);
            }
        }


    }

    private static int partCalculate(String operator, int prevValue, String input) {
        if (input == null || input.equals("")) {
            throw new IllegalArgumentException("잘못된 입력 데이터입니다.");
        }

        int inputValue = Integer.parseInt(input);
        switch (operator) {
            case "+":
                return add(prevValue, inputValue);
            case "-":
                return subtract(prevValue, inputValue);
            case "*":
                return multiply(prevValue, inputValue);
            case "/":
                return divide(prevValue, inputValue);
            default:
                throw new IllegalArgumentException("잘못된 연산자입니다.");
        }
    }

    private static boolean isPermittedOperator(String value) {
        for (String operator : permitOperator) {
            if (operator.equals(value)) {
                return true;
            }
        }
        return false;
    }
}
