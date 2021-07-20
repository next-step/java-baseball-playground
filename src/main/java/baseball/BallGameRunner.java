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

    //() no parameter, return Record, balls.match(inputBalls)...java-lotto
    public BallGameResult run() {
        return systemBalls.match(userballs);
    }

    //message to ballGameResult
    public boolean isEnd() {
        BallGameResult ballGameResult = run();
        return ballGameResult.isEndResult();
    }


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

// livecoding-step3 java-lotto
//public class LottoGame {
//    public LottoResult play(WinningLotto winningLotto) {
//        return null;
//    }
//}