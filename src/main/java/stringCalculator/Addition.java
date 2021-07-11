package stringCalculator;

public class Addition implements YesOperation {

    @Override
    public boolean yesOperate(String operator) {
        return operator.equals("+");
    }
}
