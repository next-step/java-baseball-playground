package baseball;

import java.util.List;

public class Validation {


    public static boolean confirmNumber(int i) {
        return i >= 1 && i <= 9;

    }

    public static boolean confirmDuplication(List<Integer> request) {
        //false : 중복 o , true : 중복 x
        return request.stream().distinct().count() != request.size();
    }

    public static boolean confirmSize(List<Integer> request) {
        return request.size() == 3;
    }
}
