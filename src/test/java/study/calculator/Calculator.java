package study.calculator;

public class Calculator implements CalculatorInterface{
    private String operator;
    private int answer;

    @Override
    public void calculate(int inputNum) {
        if (this.operator.equals("+")) {
            this.answer = answer + inputNum;
        }
        if (this.operator.equals("-")) {
            this.answer = answer - inputNum;
        }
        if (this.operator.equals("*")) {
            this.answer = answer * inputNum;
        }
        if (this.operator.equals("/")) {
            this.answer = (int)((float)answer / inputNum);
        }
    }

    @Override
    public void init(int inputNum) {
        this.answer = inputNum;
    }

    @Override
    public void returnValue() {
        System.out.print("answer = " + answer);
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
