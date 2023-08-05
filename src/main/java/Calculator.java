public class Calculator {

    private final ExpressionValidator validator;
    private final ExpressionInformer informer;

    public Calculator(ExpressionValidator validator, ExpressionInformer informer) {
        this.validator = validator;
        this.informer = informer;
    }

    public Double calculate(String expression) {
        validator.valid(expression);
        return informer.InformOperator(expression);
    }
}
