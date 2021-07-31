package mybaseball;

public class CheckBallNo {
    private int ballNo;
    private final int MIN_NUM = 1;
    private final int MAX_NUM = 9;

    public CheckBallNo (int num) {
        if(num > MAX_NUM || num < MIN_NUM) {
            throw new IllegalArgumentException("입력 범위 초과");
        }
        this.ballNo = num;
    }

    public int getBallNo () {
        return this.ballNo;
    }
}
