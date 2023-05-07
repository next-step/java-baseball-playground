import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    PLUS("+", (first, second) -> first + second),
    MINUS("-", (first, second) -> first - second),
    MULTIPLY("*", (first, second) -> first * second),
    DIVIDE("/", (first, second) -> first / second);

    private String symbol;
    private BiFunction<Integer, Integer, Integer> operation;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operation){
        this.symbol = symbol;
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public int operate(int first, int second){
        return operation.apply(first, second);
    }

    private static final Map<String, Operator> operatorMap =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Operator::getSymbol, Function.identity())));

}
