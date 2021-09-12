package baseball;

public class BallNumber {
    public static final int MAX_NUM = 9;
    public static final int MIN_NUM = 1;

    private int number;

    public BallNumber(int number) {
        if(number < MIN_NUM || number > MAX_NUM){
            throw new IllegalArgumentException("숫자의 값은 1부터 9 사이의 값이 되어야 한다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
