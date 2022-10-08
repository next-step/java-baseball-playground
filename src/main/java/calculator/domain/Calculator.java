package calculator.domain;

public class Calculator {
    private final UserInputReceiver userInputReceiver;
    private int returnValue;

    public Calculator(UserInputReceiver userInputReceiver) {
        this.userInputReceiver = userInputReceiver;
    }

    public int calculate() {
        prepareFirstOperateValueForCalculate();
        calculateRemainExpression();
        return returnValue;
    }

    private void prepareFirstOperateValueForCalculate() {
        this.returnValue = Integer.parseInt(userInputReceiver.getUserInput().get(0));
    }

    private void calculateRemainExpression() {
        for (int i = 1; i < userInputReceiver.getUserInput().size(); i+=2) {
            calculateTo(userInputReceiver.getUserInput().get(i), Integer.parseInt(userInputReceiver.getUserInput().get(i + 1)));
        }
    }

    private void calculateTo(String operator, int operand) {
        this.returnValue = Operator.findBySymbol(operator).operate(returnValue, operand);
    }
}
