package baseball;

public class ValidationUtils {

    public static final int MAX_NO = 10;
    public static final int MIN_NO = 0;

    public static boolean validNo(int no){
        return no > MIN_NO && no < MAX_NO;
    }
}
