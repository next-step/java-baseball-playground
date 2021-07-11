package stringCalculator;

public class Addition implements Operation {

    @Override
    public int operate(int first, int second) {
        return first + second;
    }
}
