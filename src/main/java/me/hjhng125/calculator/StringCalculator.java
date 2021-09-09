package me.hjhng125.calculator;

public class StringCalculator {

    private final String expression;
    private Operator operator;

    public StringCalculator(String expression) {
        this.expression = expression;
        this.operator = Operator.PLUS;
    }

    public double calculate() {
        String[] items = expression.split(" ");
        double result = 0;

        for (String item : items) {
            result = partialCalculate(result, item);
        }

        return result;
    }

    private double partialCalculate(double result, String item) {
        if (isNumeric(item)) {
            return applyOperation(result, Double.parseDouble(item));
        }

        operator = Operator.of(item);
        return result;
    }

    private boolean isNumeric(String item) {
        try {
            double integer = Double.parseDouble(item);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    private double applyOperation(double result, double nextNumber) {
        return operator.run(result, nextNumber);
    }
}
