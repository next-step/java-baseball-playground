package baseball2;

public class ValidationUtils2 {

    public static boolean validNo(int paramNo) {
        if (paramNo >= 1 && paramNo <= 9) {
            return true;
        }
        return false;
    }
}
