package stringCalculator;

public class Operator {
    private final String operator;

    public Operator(String operator) {
        this.operator = operator;
    }
    public boolean isPlus() {
        return operator.equals("+");
    }
    public boolean isMinus() {
        return operator.equals("-");
    }
    public boolean isMultiple() {
        return operator.equals("*");
    }
    public boolean isDivide() {
        return operator.equals("/");
    }

}
