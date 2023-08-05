import java.util.StringTokenizer;

public class ExpressionValidator {

    public void valid(String expression) {
        StringTokenizer st = new StringTokenizer(expression, " ");

        int cnt = 0;
        while (st.hasMoreTokens()) {
            String value = st.nextToken();
            cnt++;

            if (cnt % 2 == 1) {
                isNumber(value);
                continue;
            }

            isOperator(value);
        }

        if (cnt % 2 == 1) {
            return;
        }

        throw new IllegalArgumentException("수식이 올바르지 않습니다");

    }

    private void isNumber(String number) {
        try {
            Double.valueOf(number);
        } catch (Exception e) {
            throw new IllegalArgumentException("수식이 올바르지 않습니다");
        }

    }

    private void isOperator(String operator) {

        if (Operator.getValueList().contains(operator)) {
            return;
        }

        throw new IllegalArgumentException("수식이 올바르지 않습니다");
    }

}
