import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final Pattern FORMULA_PATTERN = Pattern.compile("^\\d( [+\\-*\\/] \\d){1,}$");

    public int calculate() {
        Scanner scanner = new Scanner(System.in);
        String formula = scanner.nextLine().trim();

        if (!isCompleteFormula(formula)) {
            throw new IllegalStateException("잘못된 계산식입니다.");
        }

        String[] elements = formula.split(" ");
        Stack<Integer> stack = new Stack<>();
        String operator = "";

        for (String el : elements) {
            if (isOperator(el)) {
                operator = el;
                continue;
            }

            int num = Integer.parseInt(el);
            if (!stack.isEmpty()) {
                int prev = stack.pop();
                num = getResult(prev, operator, num);
            }

            stack.push(num);
        }

        return stack.pop();
    }

    private boolean isCompleteFormula(String formula) {
        return FORMULA_PATTERN.matcher(formula).matches();
    }

    private boolean isOperator(String el) {
        return "+-*/".contains(el);
    }

    private int getResult(int prev, String operator, int num) {
        switch (operator) {
            case "+":
                return plus(prev, num);
            case "-":
                return minus(prev, num);
            case "*":
                return multiplication(prev, num);
            case "/":
                return division(prev, num);
        }

        return 0;
    }

    private int division(int prev, int num) {
        if (num == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return prev / num;
    }

    private int multiplication(int prev, int num) {
        return num * prev;
    }

    private int minus(int prev, int num) {
        return prev - num;
    }

    private int plus(int prev, int num) {
        return prev + num;
    }
}
