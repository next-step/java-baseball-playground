package baseball;

import java.util.List;
import java.util.Objects;

public class BallGameRunner {
    private final BallGame ballGame;
    private final UserBalls userballs;
    private final BallRecord ballRecord;

    public BallGameRunner(BallGame ballGame, String input) {
        this.ballGame = ballGame;
        this.userballs = new UserBalls(input);
        this.ballRecord = new BallRecord(ballGame);
    }

    public BallGame getBallGame() {
        return ballGame;
    }

    public UserBalls getUserballs() {
        return userballs;
    }

    public BallRecord getBallRecord() {
        return ballRecord;
    }

    //인자 없이, return도 없음. 실제 역할은 ballRecord에 위임
    public void run() {
        this.ballRecord.updateBallRecord(this.userballs);
    }

    public boolean isEnd() {
        return ballRecord.findBallStatusCount(BallStatus.STRIKE) == 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallGameRunner that = (BallGameRunner) o;
        return Objects.equals(getBallGame(), that.getBallGame()) &&
                Objects.equals(getUserballs(), that.getUserballs()) &&
                Objects.equals(getBallRecord(), that.getBallRecord());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBallGame(), getUserballs(), getBallRecord());
    }
}
