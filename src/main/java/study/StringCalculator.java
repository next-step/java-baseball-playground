package study;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntBinaryOperator;


public class StringCalculator {

    private List<Integer> numberList;
    private List<String> operatorList;
    private Integer result;

    public StringCalculator(String input) {
        init(input);
        validate();
        this.result = calculate();
    }

    private void init(String input) {
        numberList = new ArrayList<>();
        operatorList = new ArrayList<>();
        String[] values = input.split(" ");
        for (int i = 0; i < values.length; i = i + 2) {
            numberList.add(Integer.parseInt(values[i]));
        }
        for (int i = 1; i < values.length; i = i + 2) {
            operatorList.add(values[i]);
        }
    }

    private Integer calculate() {
        Integer num1 = numberList.get(0);
        Integer num2 = numberList.get(1);
        for (int i = 0; i < operatorList.size(); i++) {
            num1 = Operator.convert(operatorList.get(i)).calculate(num1, num2);
            num2 = i + 2 < numberList.size() ? numberList.get(i + 2) : 0;
        }
        return num1;
    }

    public void validate() {
        if (numberList.size() < 2 || operatorList.isEmpty()) {
            throw new IllegalArgumentException("계산식을 잘못 입력했습니다.");
        }
    }

    public Integer getResult() {
        return result;
    }

    private enum Operator {
        PLUS("+", (num1, num2) -> num1 + num2),
        MINUS("-", (num1, num2) -> num1 - num2),
        MULTIPLE("*", (num1, num2) -> num1 * num2),
        SUB("/", (num1, num2) -> num1 / num2);

        private final String operator;
        private final IntBinaryOperator expression;

        Operator(String operator, IntBinaryOperator expression) {
            this.operator = operator;
            this.expression = expression;
        }

        public Integer calculate(Integer num1, Integer num2) {
            return expression.applyAsInt(num1, num2);
        }

        public static Operator convert(String input) {
            for (Operator type : Operator.values()) {
                if (type.operator.equals(input)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("잘못된 연산자가 사용되었습니다.");
        }

    }

}
