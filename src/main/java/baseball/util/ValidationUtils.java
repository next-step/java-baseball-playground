package baseball.util;

import java.util.List;
import java.util.regex.Pattern;

public class ValidationUtils {

    private static final String NUMBER_REGEX = "^[0-9]*$";

    public static boolean isNumber(String text) {
        return Pattern.matches(NUMBER_REGEX, text);
    }

    public static boolean isDuplicationNumber(List<Integer> numberList) {
        long distinctCount = numberList.stream()
                .distinct()
                .count();

        return numberList.size() != distinctCount;
    }
}
