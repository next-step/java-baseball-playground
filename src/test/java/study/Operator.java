package study;

public class Operator {
    String operator = null;
    public Operator(String operator) {
        if(operator.equals("+") || operator.equals("-") ||
        operator.equals("*") || operator.equals("/"))
        {
            this.operator = operator;
        }
        if(this.operator == null)
        {
            throw new IllegalArgumentException();
        }
    }
}
