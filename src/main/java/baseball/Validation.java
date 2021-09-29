package baseball;

import java.util.List;

public class Validation {


    public static boolean confirmNumber(int i) {
        return i >= 1 && i <= 9;

    }

    public static boolean confirmDuplication(List<Integer> request) {
        // true 중복 x / false 중복ㄴ
        return request.stream().distinct().count() == request.size();
    }

    public static boolean confirmSize(List<Integer> request) {
        return request.size() == 3;
    }
}
