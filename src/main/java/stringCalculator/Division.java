package stringCalculator;

public class Division implements YesOperation {

    @Override
    public boolean yesOperate(String operator) {
        return operator.equals("/");
    }
}
