package study.calculator;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Expression {

    private final String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    public List<Object> splitByBlank() {
        return Arrays.stream(expression.split(" "))
                .map(String::new)
                .collect(Collectors.toList());
    }
}