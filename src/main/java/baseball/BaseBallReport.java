package baseball;

public class BaseBallReport {

    private int strikeCount;
    private int ballCount;


    @Override
    public String toString() {
        String message = String.format("%d볼 %d스트라이크", this.ballCount, this.strikeCount);
        if (isZero())
            message = "낫싱";

        return message;
    }

    private boolean isZero() {
        return this.strikeCount == 0 && this.ballCount == 0;
    }

    public void report(BaseBallStatus status) {
        if (status.isStrike()){
            this.strikeCount++;
        }

        if (status.isBall()){
            this.ballCount++;
        }
    }
}
