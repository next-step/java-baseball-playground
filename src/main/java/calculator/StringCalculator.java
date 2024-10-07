package calculator;

import java.util.Scanner;

public class StringCalculator {

    private final Scanner scanner;

    public StringCalculator(final Scanner scanner) {
        this.scanner = scanner;
    }

    public String input() {
        return scanner.nextLine();
    }

    public int calculatorResult(String input) {
        final String[] split = input.split(" ");
        int result = Integer.parseInt(split[0]);
        String operator;
        for (int i = 1; i < split.length; i = i + 2) { // 1,3,5,7,~~
            final int num = Integer.parseInt(split[i + 1]);
            operator = split[i];
            result = operation(operator, num, result);
        }
        return result;
    }

    private int operation(final String operator, final int num, int result) {
        switch (operator) {
            case "+":
                result += num;
                break;
            case "-":
                result -= num;
                break;
            case "*":
                result *= num;
                break;
            case "/":
                result /= num;
                break;
            default:
                throw new IllegalArgumentException("잘못된 연산자입니다.");
        }
        return result;
    }
}
