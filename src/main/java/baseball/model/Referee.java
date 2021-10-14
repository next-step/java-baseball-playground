package baseball.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Referee {
    private static final int MAX_LENGTH = 3;

    public static List<Integer> judgement(Balls answerBalls, Balls userBalls) {

        List<BallStatus> statusList = new ArrayList<>();

        for (int i = 0; i < MAX_LENGTH; i++) {
            statusList.addAll(judgeAllBalls(answerBalls, userBalls.getBalls().get(i)));
        }

        int strike = (int) statusList.stream().filter(s -> s == BallStatus.STRIKE).count();
        int ball = (int) statusList.stream().filter(s -> s == BallStatus.BALL).count();

        return Arrays.asList(strike,ball);
    }

    public static boolean isOut(List<Integer> judgeResult){
        int strike = judgeResult.get(0);

        if(strike==3){
            return true;
        }
        return false;
    }

    private static List<BallStatus> judgeAllBalls(Balls answerBalls, Ball userBall) {
        List<BallStatus> statusList = new ArrayList<>();
        for (Ball ab : answerBalls.getBalls()) {
            statusList.add(judgeOneBall(ab, userBall));
        }
        return statusList;

    }

    private static BallStatus judgeOneBall(Ball answerBall, Ball userBall) {
        if (isStrike(answerBall, userBall)) {
            return BallStatus.STRIKE;
        }
        if (isBall(answerBall, userBall)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private static boolean isStrike(Ball answerBall, Ball userBall) {
        if (answerBall.equals(userBall)) {
            return true;
        }
        return false;
    }

    private static boolean isBall(Ball answerBall, Ball userBall) {
        if (answerBall.getBall() == userBall.getBall()) {
            return true;
        }
        return false;
    }


}
