package Calculator;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToIntBiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    PLUS("+", (first, second) -> first + second),
    MINUS("-", (first, second) -> first - second),
    MULTIPLY("*", (first, second) -> first * second),
    DEVIDE("/", (first, second) -> {
        if(second == 0) {
            throw new IllegalArgumentException();
        }
        return first / second;
    });

    private static final Map<String, Operator> operatorMap = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors
                    .toMap(Operator::getOperator, Function.identity())));

    private String operator;
    private ToIntBiFunction<Integer, Integer> toIntBiFunction;

    Operator(String operator, ToIntBiFunction<Integer, Integer> toIntBiFunction) {
        this.operator = operator;
        this.toIntBiFunction = toIntBiFunction;
    }

    public int operate(int first, String second) {
        return toIntBiFunction.applyAsInt(first, Integer.valueOf(second));
    }

    public static Operator findByOperator(String key) {
        /*
        return Stream.of(values())
                .filter(operator -> operator.getOperator().equals(key))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
         */
        return operatorMap.get(key);
    }

    public String getOperator() {
        return operator;
    }

    public static Operator isPlus() {
        return Operator.PLUS;
    }

    public static Operator isMinus() {
        return Operator.MINUS;
    }

    public static Operator isMultiply() {
        return Operator.MULTIPLY;
    }

    public static Operator isDevide() {
        return Operator.DEVIDE;
    }
}
