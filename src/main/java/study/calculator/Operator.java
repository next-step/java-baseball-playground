package study.calculator;


import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public enum Operator {
    // enum 클래스를 사용해서 그 일에 대한 책임을 갖고 있는 객체가 상태(값)와 행위(로직)를 가질 수 있다.
    PLUS("+", (left, right) -> left + right),
    MINUS("-", (left, right) -> left - right),
    MULTIPLY("*", (left, right) -> left * right),
    DIVISION("/", (left, right) -> left / right);

    private final BinaryOperator<Double> expression;
    private final String symbol;

    Operator(String symbol, BinaryOperator<Double> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public Double calculate(double left, double right) {
        return expression.apply(left, right);
    }

    public static Operator getOperator(String symbol) {
        return Stream.of(Operator.values())
                .filter(op -> op.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid operator symbol: " + symbol));
    }

}