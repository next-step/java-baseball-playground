package me.hjhng125.calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", Double::sum),
    MINUS("-", (a, b) -> a - b),
    MUL("*", (a,b) -> a * b),
    DIV("/", (a, b) -> a / b),
    ;

    private final String operator;
    private final BiFunction<Double, Double, Double> expression;

    Operator(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public double run(double a, double b) {
        return expression.apply(a, b);
    }

    public static Operator of(String operatorString) {
        return Arrays.stream(values())
            .filter(item -> item.operator.equals(operatorString))
            .findFirst()
            .orElseThrow(IllegalAccessError::new);
    }
}
