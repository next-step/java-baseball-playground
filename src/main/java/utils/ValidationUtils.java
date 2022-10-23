package utils;

import java.util.List;

public class ValidationUtils {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private static final int DIGIT_COUNT = 3;

    public boolean validateNumber(int number) {
        return number >= MIN_VALUE && number <= MAX_VALUE;
    }

    public boolean validateDigit(List<Integer> numbers) {
        return numbers.size() == DIGIT_COUNT;
    }
}
