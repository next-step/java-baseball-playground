package study.calculator;


import java.util.List;

class Calculator {

    public static Double calculate(List<Object> input) {
        double result = Double.parseDouble((String) input.get(0));

        for (int i = 1; i < input.size(); i += 2) {
            String operatorSymbol = input.get(i).toString();
            Operator operator = Operator.getOperator(operatorSymbol);
            double right = Double.parseDouble((String) input.get(i + 1));
            result = operator.calculate(result, right);
        }
        return result;
    }
}
