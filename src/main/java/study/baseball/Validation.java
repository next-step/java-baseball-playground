package study.baseball;

public class Validation {
    public static final int MAX_NUMBER = 10;
    public static final int MIN_NUMBER = 0;

    private Validation() {}

    public static boolean validNumber(int number) {
        return number > MIN_NUMBER && number < MAX_NUMBER;
    }
}
