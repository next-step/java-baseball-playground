package stringcalculator;

public class Operator {
    static Calculator cal = new Calculator();

    public static int operate(int firstNum, String operator, int secondNum) {

        if (operator.equals("+")) {
            return cal.add(firstNum, secondNum);
        }
        if (operator.equals("-")) {
            return cal.sub(firstNum, secondNum);
        }
        if (operator.equals("*")) {
            return cal.mul(firstNum, secondNum);
        }
        if (operator.equals("/")) {
            return cal.div(firstNum, secondNum);
        }
        return 0;
    }

    static boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
}
