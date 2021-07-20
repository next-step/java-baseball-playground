package baseball;

import java.util.*;

import static baseball.BallStatus.BALL;
import static baseball.BallStatus.STRIKE;

public class BallGameResult {

    private final List<Map<BallStatus, Integer>> ballGameResult;

    BallGameResult(List<Map<BallStatus, Integer>> ballGameResult){
        this.ballGameResult = ballGameResult;
    }
    BallGameResult(){
        this (makeEmptyBallGameResult());
    }

    private static List<Map<BallStatus, Integer>> makeEmptyBallGameResult() {
        Map<BallStatus, Integer> initStrike = new HashMap<>();
        initStrike.put(STRIKE, 0);
        Map<BallStatus, Integer> initBall = new HashMap<>();
        initBall.put(BALL, 0);
        return Arrays.asList(initStrike, initBall);
    }

    public List<Map<BallStatus, Integer>> getBallGameResult() {
        return ballGameResult;
    }

    public void addCount(BallStatus ballStatus) {
        ballGameResult.stream()
                .filter(o -> o.containsKey(ballStatus))
                .forEach(o -> o.put(ballStatus, o.get(ballStatus) + 1));
    }

    public boolean isZero(BallStatus ballStatus) {
        return getCount(ballStatus) == 0;
    }

    public int getCount(BallStatus ballStatus) {
        return ballGameResult.stream()
                .filter(o -> o.containsKey(ballStatus))
                .findFirst()
                .map(o -> o.get(ballStatus))
                .orElse(0);
    }

    public boolean isEndResult() {
        return getCount(STRIKE) == 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallGameResult that = (BallGameResult) o;
        return Objects.equals(getBallGameResult(), that.getBallGameResult());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBallGameResult());
    }

}
