package stringcalculator;

public class Result {

    public static int calculateResult() {
        String value = Input.inputData(Input.scan);
        Expression expression = new Expression(value);
        String[] splitedValue = expression.getExpression();

        int result = Integer.parseInt(splitedValue[0]);
        String operator = "";

        for (int i = 1; i < splitedValue.length; i++) {
            if (Operator.isOperator(splitedValue[i])) {
                operator = splitedValue[i];
            } else {
                int number = Integer.parseInt(splitedValue[i]);

                result = Operator.operate(result, operator, number);
            }
        }
        return result;
    }
}
