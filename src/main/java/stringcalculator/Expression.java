package stringcalculator;

public class Expression {

    private String[] expression;

    public Expression(String expression) {
        this.expression = expression.split(" ");
    }

   public String[] getExpression() {
        return expression;
   }
}
