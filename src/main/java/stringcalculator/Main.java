package stringcalculator;

public class Main {
    public static void main(String[] args) {
        int result = calculateResult();
        System.out.println(result);
    }

    public static int calculateResult() {
        String value = Input.inputData();
        Expression expression = new Expression(value);
        String[] splitedValue = expression.getExpression();

        int result = Integer.parseInt(splitedValue[0]);
        String operator = "";

        for (int i = 1; i < splitedValue.length; i++) {
            if (isOperator(splitedValue[i])) {
                operator = splitedValue[i];
            } else {
                int number = Integer.parseInt(splitedValue[i]);
                result = Operator.operate(result, operator, number);
            }
        }
        return result;
    }

    static boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
}
