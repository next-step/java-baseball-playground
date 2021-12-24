package stringCalculator;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class StringCalculator extends Calculator {

    private String getInput(Scanner sc) {
        return sc.nextLine();
    }

    private Deque<String> getExpression(String input) {
        String[] strings = input.split(" ");
        Deque<String> expr = new LinkedList<>();
        for (String str : strings) {
            expr.addLast(str);
        }
        return expr;
    }

    private int operate(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return add(a, b);
            case "-":
                return subtract(a, b);
            case "*":
                return multiply(a, b);
            case "/":
                return divide(a, b);
            default:
                return 0;
        }
    }

    private String calculate(Deque<String> expression) {
        while (expression.size() > 1) {
            int a = Integer.parseInt(expression.removeFirst());
            String operator = expression.removeFirst();
            int b = Integer.parseInt(expression.removeFirst());
            int result = operate(a, b, operator);
            expression.addFirst(String.valueOf(result));
        }
        return expression.getFirst();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(calculate(getExpression(getInput(scanner))));
        scanner.close();
    }

    public String runWithoutUserInput(String input) {
        return calculate(getExpression(input));
    }

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        calculator.run();
    }
}