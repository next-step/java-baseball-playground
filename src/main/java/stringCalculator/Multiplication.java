package stringCalculator;

public class Multiplication implements YesOperation {

    @Override
    public boolean yesOperate(String operator) {
        return operator.equals("*");
    }
}
