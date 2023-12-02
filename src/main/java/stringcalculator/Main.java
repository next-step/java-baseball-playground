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

        int result = 0;
        String operator = "";

        for (String data : splitedValue) {
            if (isOperator(data)) {
                operator = data; //연산자를 저장
            } else { //숫자
                int number = Integer.parseInt(data);
                result = Operator.operate(result, operator, number);
            }
        }
        return result;
    }

    static boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
}
