package baseball;

public class ValidationUtils {

    public static final int MIN_NUM= 0;
    public static final int MAX_NUM = 10;

    public static boolean validNumFromOneToNine(int num) {
        return num > MIN_NUM && num < MAX_NUM;
    }
}
