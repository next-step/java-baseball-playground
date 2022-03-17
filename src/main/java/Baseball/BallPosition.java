package Baseball;

public class BallPosition {
    private int ballPos;

    public BallPosition(int ballPos) {
        this.ballPos = ballPos;
    }

    public int getBallPos() {
        return ballPos;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BallPosition
        && ((BallPosition)obj).getBallPos() == this.getBallPos()) {
            return true;
        }

        return false;
    }
}
