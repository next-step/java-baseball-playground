import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Operator {

    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String value;
    private final BiFunction<Double, Double, Double> function;

    Operator(String value, BiFunction<Double, Double, Double> function) {
        this.value = value;
        this.function = function;
    }

    public String getValue() {
        return value;
    }

    public static List<String> getValueList() {
        return Arrays.stream(Operator.values()).map(Operator::getValue)
            .collect(Collectors.toList());
    }

    public Double function(Double a, Double b) {
        return this.function.apply(a, b);
    }


}
