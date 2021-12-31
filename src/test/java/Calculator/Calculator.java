package Calculator;

import java.util.Scanner;


public class Calculator {

    static int index = 0;

    static int operation(int result, int operator, int operand) {
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

    static int checkOperator(String str) {
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

    static int parseString(String value) {
        char result;
        int operator;

        operator = checkOperator(value);
        return (operator);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        int result = 0;
        int operator = 0;
        int operand = 0;
        String[] str = value.split(" ");

        //첫번째 값 저장
        result = Integer.parseInt(str[index]);
        index++;
        while (index < str.length) {
            operator = parseString(str[index]);
            index++;
            operand = Integer.parseInt(str[index]);
            index++;
            result = operation(result, operator, operand);
        }
        System.out.printf("result: %d", result);
    }
}
