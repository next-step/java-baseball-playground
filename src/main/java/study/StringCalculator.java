package study;

public class StringCalculator {

    public String calculate(String stringFormula) throws IllegalArgumentException {
        Formula formula = new Formula(stringFormula);
        if(!formula.isValidate()) throw new IllegalArgumentException();

        Integer accumulated = Integer.parseInt(formula.getValue(0));
        for(int i = 2; i < formula.getLength(); i += 2) {
            accumulated = operates(accumulated, FourOperators.get(formula.getValue(i - 1)), Integer.parseInt(formula.getValue(i)));
        }
        return String.valueOf(accumulated);
    }

    private Integer operates(Integer accumulated, FourOperators operator, Integer operand) {
        if (FourOperators.PLUS == operator) accumulated += operand;
        if (FourOperators.MINUS == operator) accumulated -= operand;
        if (FourOperators.TIMES == operator) accumulated *= operand;
        if (FourOperators.DIVIDE == operator) accumulated /= operand;
        return accumulated;
    }

}
