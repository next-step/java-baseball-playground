package baseball;

public class BallGame {

    private final Ball comBall;

    BallGame(Ball comBall) {
        this.comBall = comBall;
    }
    //하나의 Game에서 사용자는 반복해 맞추나, 컴퓨터는 유지

    //정리 필요!! this not in Static content
    public BallStatus match(Ball usrBall) {
        if (this.comBall.equals(usrBall)) {
            return BallStatus.STRIKE;
        }
        if (this.isStatusOfBall(usrBall)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean isStatusOfBall(Ball usrBall) {
        return (this.comBall.isSameNumOf(usrBall))
            && (!this.comBall.isSameSlotOf(usrBall));
    }
}
