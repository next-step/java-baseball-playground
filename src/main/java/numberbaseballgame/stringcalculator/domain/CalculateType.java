package numberbaseballgame.stringcalculator.domain;

import java.util.function.BiFunction;

public enum CalculateType {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIED_BY("/", (x, y) -> x / y);

    private final String operationSymbol;
    private final BiFunction<Integer, Integer, Integer> expression;

    CalculateType(String operationSymbol, BiFunction<Integer, Integer, Integer> expression) {
        this.operationSymbol = operationSymbol;
        this.expression = expression;
    }

    public int calculate(int x, int y) {
        return expression.apply(x, y);
    }

    public static void main(String[] args) {
        System.out.println(CalculateType.PLUS.calculate(1, 2));
        System.out.println(CalculateType.MINUS.calculate(1, 2));
        System.out.println(CalculateType.TIMES.calculate(1, 2));
        System.out.println(CalculateType.DIVIED_BY.calculate(1, 2));
    }

}
