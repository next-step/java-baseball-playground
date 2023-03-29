package baseball;

public class ValidationUtils {

    public static final int MIN_NUM = -1;
    public static final int MAX_NUM = 9;

    public static boolean validNumTest(int num) {
//        if( -1 < num && num <= 9)return true;
//        return false;
        return  MIN_NUM < num && num <= MAX_NUM;
    }
}
