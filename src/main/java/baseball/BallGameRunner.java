package baseball;

import java.util.Objects;

public class BallGameRunner {
    private final SystemBalls systemBalls;
    private final UserBalls userballs;

    public BallGameRunner(SystemBalls systemBalls, String input) {
        this.systemBalls = systemBalls;
        this.userballs = new UserBalls(input);
    }

    public SystemBalls getSystemBalls() {
        return systemBalls;
    }

    public UserBalls getUserballs() {
        return userballs;
    }

    //인자 없이, return도 없음. 실제 역할은 ballRecord에 위임
    public void run() {

    }

    // public boolean isEnd() {
     //   return ballGameRecord.findBallStatusCount(BallStatus.STRIKE) == 3;
    //}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallGameRunner that = (BallGameRunner) o;
        return Objects.equals(getSystemBalls(), that.getSystemBalls()) &&
                Objects.equals(getUserballs(), that.getUserballs());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSystemBalls(), getUserballs());
    }
}
