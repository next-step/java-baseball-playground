package baseball;

import java.util.List;

public class ValidationUtils {

    private static final int MIN_NO = 0;

    private static final int MAX_NO = 10;

    public static boolean ValidNo(int no) {
        return no > MIN_NO && no < MAX_NO;
    }

    public static boolean ValidNoList(List<Integer> answerNoList) {

        if (answerNoList.size() != 3) {
            return false;
        }

        return true;
    }
}
