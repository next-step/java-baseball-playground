package baseball;

public class ValidationUtils {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    public boolean validateNumber(int number) {
        return number >= MIN_VALUE && number <= MAX_VALUE;
    }
}
