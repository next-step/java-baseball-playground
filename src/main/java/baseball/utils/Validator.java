package baseball.utils;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    public static void checkIsNumber(String number) {
        String numberRegularExpress = "^[0-9]$";
        boolean isNotNumber = !(number.matches(number));
        if (isNotNumber) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public static void checkSize(String number) {
        final int EXACT_SIZE = 3;
        int length = number.length();
        if (length != EXACT_SIZE) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
    }

    public static void checkBoundary(String number) {
        String numberRegularExpress = "^[1-9]$";
        boolean isNotBoundary = !(number.matches(number));
        if (isNotBoundary) {
            throw new IllegalArgumentException("1부터 9까지의 숫자를 입력해주세요.");
        }
    }

    public static void checkDuplicate(String number) {
        final int EXACT_SIZE = 3;
        Set<Character> map = new HashSet<>();
        for (int cipher = 0; cipher < number.length(); cipher++) {
            map.add(number.charAt(cipher));
        }
        if (map.size() != EXACT_SIZE) {
            throw new IllegalArgumentException("숫자는 서로 중복되지 않아야합니다.");
        }
    }
}
