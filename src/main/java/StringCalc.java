import java.util.regex.Pattern;

public class StringCalc {
    private static final Pattern NUMBER_REGEXP = Pattern.compile("^[0-9]*$");
    private Formula formula;

    public StringCalc(Formula formula) {
        this.formula = formula;
    }

    public int calc() {

        int sum = 0;
        Operator currentOperator = Operator.PLUS;

        for (String input : formula.getFormula()) {
            if (NUMBER_REGEXP.matcher(input).find()) {
                sum = currentOperator.operate(sum, Integer.valueOf(input));
                continue;
            }

            currentOperator = Operator.findOperator(input);
        }

        return sum;
    }
}
