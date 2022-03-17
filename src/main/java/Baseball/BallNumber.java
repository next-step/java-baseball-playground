package Baseball;

public class BallNumber {
    private final int MIN_NO = 1;
    private final int MAX_NO = 9;

    private int ballNumber;

    public BallNumber(int ballNumber) {
        if(ballNumber < MIN_NO || ballNumber > MAX_NO) {
            throw new IllegalArgumentException("볼 숫자는 1부터 9까지의 값이어야 합니다.");
        }
        this.ballNumber = ballNumber;
    }

    public int getBallNumber() {
        return ballNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BallNumber
        && ((BallNumber)obj).getBallNumber() == this.getBallNumber()) {
            return true;
        }

        return false;
    }
}
