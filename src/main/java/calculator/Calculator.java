package calculator;

import java.util.Scanner;

public class Calculator {
    public String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int calculate(String input) {
        String[] arr = input.split(" ");
        int result = Integer.parseInt(arr[0]);
        String op;
        for (int i = 1; i < arr.length; i = i + 2) {
            op = arr[i];
            int num = Integer.parseInt(arr[i + 1]);
            result = operateResult(op, result, num);
        }
        return result;
    }

    public int operateResult(String operator, int result, int num) {
        switch (operator) {
            case "+":
                result = add(result, num);
                break;
            case "-":
                result = substract(result, num);
                break;
            case "*":
                result = multiply(result, num);
                break;
            case "/":
                result = divide(result, num);
                break;
            default:
                throw new IllegalArgumentException("잘못된 연산자입니다.");
        }
        return result;
    }

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int substract(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        return num1 / num2;
    }
}
