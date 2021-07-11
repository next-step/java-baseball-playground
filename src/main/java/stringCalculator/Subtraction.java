package stringCalculator;

public class Subtraction implements YesOperation{

    @Override
    public boolean yesOperate(String operator) {
        return operator.equals("-");
    }
}
