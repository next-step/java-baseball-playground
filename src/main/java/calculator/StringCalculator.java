package calculator;

import java.util.LinkedList;

public class StringCalculator {

    private String[] values;
    private LinkedList<Double> operands;
    private LinkedList<String> operators;

    private Double result;

    public StringCalculator() {
        this.operands = new LinkedList<>();
        this.operators = new LinkedList<>();
    }

    public double getResult() {
        return result;
    }

    public void enter(String s) {
        values = s.split(" ");      // values 초기화
        if (values.length < 3) {
            throw new IllegalArgumentException("3글자 이상 입력해 주세요.");
        }
        for (int i = 0; i < values.length; i++) {
            validate(i, values[i]);
            if (isDigit(values[i])) {
                operands.add(Double.valueOf(values[i]));
            }
            if (isOperator(values[i])) {
                operators.add(values[i]);
            }
        }
    }

    public void calculateAll() {
        result = operands.pop();
        while (!operands.isEmpty()) {
            calculate(result, operands.pop(), operators.pop());
        }
    }

    public void calculate(double x, double y, String operator) {
        if ("+".equals(operator)) {
            result = x + y;
        } else if ("-".equals(operator)) {
            result = x - y;
        } else if ("*".equals(operator)) {
            result = x * y;
        } else if ("/".equals(operator)) {
            if (y == 0) {
                throw new IllegalArgumentException("0으로 나눌수 없습니다");
            }
            result = x / y;
        }
    }

    public void validate(int idx, String value) {
        if (idx % 2 == 0 && !isDigit(value)) {  // 짝수번째: 숫자가 와야함
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        if (idx % 2 == 1 && !isOperator(value)) {   // 홀수번째: operator 가 와야함
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public boolean isDigit(String value) {
        return value.matches("^0|[1-9]+[0-9]*");
    }

    public boolean isOperator(String value) {
        return value.matches("[+\\-*/]");
    }
}
