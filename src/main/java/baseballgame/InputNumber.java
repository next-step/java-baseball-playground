package baseballgame;

public class InputNumber {

    public static final int MIN = 1;
    public static final int MAX = 9;



    public static boolean validateNumberRange(int num) {
        return MIN <= num && num <= MAX;
    }

}
