package study;

public class StringCalculator {

    public int calculate(int left, String operator, int right) {
        int result = 0;
        if (operator == "+") {
            result = left + right;
        } else if (operator == "-") {
            result = left - right;
        } else if (operator == "*") {
            result = left * right;
        } else if (operator == "/") {
            if (right == 0) {
                throw new IllegalArgumentException("Division by zero");
            }
            result = left / right;
        } else {
            throw new IllegalArgumentException(operator + " not supported operator");
        }
        return result;
    }
}
