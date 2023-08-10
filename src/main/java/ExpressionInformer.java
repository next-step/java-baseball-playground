import java.util.StringTokenizer;

public class ExpressionInformer {

    public Double InformOperator(String expression) {

        StringTokenizer st = new StringTokenizer(expression, " ");

        Double valueA = Double.valueOf(st.nextToken());
        String operator = st.nextToken();
        Double valueB = Double.valueOf(st.nextToken());

        Operator firstOperator = findOperator(operator);
        Double calculationValue = firstOperator.function(valueA, valueB);

        while (st.hasMoreTokens()) {
            Operator nextOperator = findOperator(st.nextToken());
            Double valueC = Double.valueOf(st.nextToken());
            calculationValue = nextOperator.function(calculationValue, valueC);
        }

        return calculationValue;

    }

    private static Operator findOperator(String operator) {
        for (Operator value : Operator.values()) {
            if(value.getValue().equals(operator)) {
                return value;
            }
        }

        return null;
    }
}
