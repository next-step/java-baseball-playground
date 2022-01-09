package baseball;

public class BallNumber {

    public static final int MAX_NO = 10;
    public static final int MIN_NO = 0;
    public int no;

    public BallNumber(int no){
        if (no < MIN_NO || no > MAX_NO){
            throw new IllegalArgumentException("볼 숫자는 1부터 9의 값이어야 합니다.");
        }
        this.no = no;
    }
}
