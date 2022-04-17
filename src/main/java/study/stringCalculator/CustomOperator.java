package study.stringCalculator;

import java.util.Objects;

public class CustomOperator {

    public Number doOperation(Number first, String op, Number second) {
        if (Objects.equals(op, "+")) return first.plus(second);
        if (Objects.equals(op, "-")) return first.minus(second);
        if (Objects.equals(op, "*")) return first.multiply(second);
        if (Objects.equals(op, "/")) return first.dividedBy(second);

        throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
    }

    public void init() {
    }
}
