package study.stringCalculator;

public class StringCalculator {

    private final Input input = new Input();
    private final CustomOperator operator = new CustomOperator();
    private final Number result = new Number();
    private String[] unitStrings;

    public StringCalculator init() {
        input.init();
        operator.init();
        result.init();
        return this;
    }

    public StringCalculator input(String s) {
        input.update(s);
        return this;
    }

    public StringCalculator splitInput(String splittedBy) {
        unitStrings = input.split(splittedBy);
        return this;
    }

    public int calculate() {
        if (unitStrings.length == 0) throw new IllegalStateException("unitStrings must have elements");

        result.initResult(unitStrings[0]);
        for (int i = 1; i < unitStrings.length; i += 2) {
            String op = unitStrings[i];
            Number number = Number.from(unitStrings[i+1]);
            operator.doOperation(result, op, number);
        }
        return result.toInt();
    }
}
