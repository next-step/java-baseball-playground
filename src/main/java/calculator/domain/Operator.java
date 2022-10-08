package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (operand1, operand2) -> operand1 + operand2),
    MINUS("-", (operand1, operand2) -> operand1 - operand2),
    DIVIDE("/", (operand1, operand2) -> operand1 / operand2),
    MODULUS("%", (operand1, operand2) -> operand1 % operand2);


    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> operateFun;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operateFun) {
        this.symbol = symbol;
        this.operateFun = operateFun;
    }

    public static Operator findBySymbol(String symbol) {
        return Arrays.stream(values())
                .filter(op -> op.getSymbol().equals(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 사칙연산이 없습니다"));
    }

    private String getSymbol() {
        return this.symbol;
    }

    public int operate(int operand1, int operand2) {
        return operateFun.apply(operand1, operand2).intValue();
    }
}