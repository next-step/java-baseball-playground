package Baseball;

public class BallPosition {
    private final int MIN_POSITION = 1;
    private final int MAX_POSITION = 3;

    private int position;

    public BallPosition(int position) {
        if(position < MIN_POSITION || position > MAX_POSITION) {
            throw new IllegalArgumentException("볼숫자는 3자리 숫자입니다.");
        }
        this.position = position;
    }

    @Override
    public boolean equals(Object ballPosition) {
        if(ballPosition instanceof BallPosition
                && ((BallPosition) ballPosition).getPosition() == position) {
            return true;
        }
        return false;
    }

    public int getPosition() {
        return position;
    }
}
