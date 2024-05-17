package baseball;

public class ValidationCheck {


    private static final int MIN_NO = 0;
    private static final int MAX_NO = 10;

    public static boolean isThreeWord(String input) {
        return input.length() == 3;
    }

    public static boolean isCorrect(int no) {
        return no > MIN_NO && no < MAX_NO;
    }
}
