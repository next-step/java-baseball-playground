package calculator;

import java.util.Scanner;


public class Calculator {

    static int index = 0;

    static int calculating(int result, int operator, int operand) {
        if (operator == 1) {
            return (result + operand);
        }
        if (operator == 2) {
            return (result - operand);
        }
        if (operator == 3) {
            return (result * operand);
        }
        if (operator == 4) {
            return (result / operand);
        }
        return (0);
    }

    public int checkOperator(String str) {
        if (str.equals("+")) {
            return (1);
        }
        if (str.equals("-")) {
            return (2);
        }
        if (str.equals("*")) {
            return (3);
        }
        if (str.equals("/")) {
            return (4);
        }
        return (0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        int result = 0;
        int operator = 0;
        int operand = 0;

        Calculator calculator = new Calculator();
        String[] str = value.split(" ");
        result = Integer.parseInt(str[index]);
        index++;
        while (index < str.length) {
            operator = calculator.checkOperator(str[index]);
            index++;
            operand = Integer.parseInt(str[index]);
            index++;
            result = calculating(result, operator, operand);
        }
        System.out.printf("result: %d", result);
    }
}