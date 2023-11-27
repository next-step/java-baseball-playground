package stringCalculator;

import static stringCalculator.Operator.isOperator;

public class Main {
    public static void main(String[] args) {
        String value = Input.inputData();
        Expression expression = new Expression(value);
        String[] splitedValue = expression.getExpression();

        int result = 0;
        String operator = "";

        for (String data : splitedValue) {
            if (isOperator(data)) {
                operator = data; //연산자를 저장
            }
            else { //숫자
                int number = Integer.parseInt(data);
                result = Operator.operate(result, operator, number);
            }

            System.out.println(result);
        }



    }
}
