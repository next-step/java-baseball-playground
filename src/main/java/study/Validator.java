package study;

import java.util.List;

public class Validator {
    public static boolean checkSize(List list) {
        if (list.size() == 3) {
            return true;
        }
        return false;
    }

    public static boolean isUnique(int number, List list) {
        if (list.contains(number)) {
            return false;
        }
        return true;
    }
}
