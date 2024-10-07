package baseball;

import java.util.HashSet;
import java.util.Set;

public class ValidationUtils {

    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 10;

    public static boolean validNo(int no) {
        return no > MIN_VALUE && no < MAX_VALUE;
    }

    public static boolean validNoDuplication(int balls) {

        String numbers = String.valueOf(balls);
        Set<Character> set = new HashSet<>();
        char[] numbersCharArray = numbers.toCharArray();

        for (char num : numbersCharArray) {
            if (!set.add(num)) {
                return false;
            }
        }

        return true;
    }

    public static boolean validLengthThree(int balls) {
        return String.valueOf(balls).length() == 3;
    }
}
