package baseball;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private static final int MAX_LENGTH = 3;

    public static boolean judgement(Balls answerBalls, Balls userBalls) {

        List<BallStatus> statusList = new ArrayList<>();

        for (int i = 0; i < MAX_LENGTH; i++) {
            statusList.addAll(judgeAllBalls(answerBalls, userBalls.getBalls().get(i)));
        }

        int strike = (int) statusList.stream().filter(s -> s == BallStatus.STRIKE).count();
        int ball = (int) statusList.stream().filter(s -> s == BallStatus.BALL).count();

        printResult(strike, ball);
        if(strike == 3){
            return true;
        }
        return false;
    }

    private static void printResult(int strike, int ball) {
        if (strike != 0 && ball != 0) {
            System.out.println(strike + "스트라이크 " + ball + "볼");
        }
        if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        }
        if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        if (strike == 3) {
            System.out.println("정답을 맞히셨습니다! 게임 종료.");
        }
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
