public class StringCalculator {
    public int calculate(String value) {
        String[] values = value.split(" ");
        int result = stringToInt(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            String operator = values[i];
            int rightNumber = stringToInt(values[i + 1]);
            result = operate(operator, result, rightNumber);
        }
        return result;
    }

    private int stringToInt(String s) {
        return Integer.parseInt(s);
    }

    private int operate(String operator, int lastValue, int rightNumber) {
        if (operator.equals("+")) {
            return lastValue + rightNumber;
        }
        if (operator.equals("*")) {
            return lastValue * rightNumber;
        }
        if (operator.equals("-")) {
            return lastValue - rightNumber;
        }
        if (operator.equals("/")) {
            return lastValue / rightNumber;
        }
        throw new IllegalArgumentException("연산자를 제대로 입력해주세요.");
    }
}
