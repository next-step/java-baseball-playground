package baseball;

import java.util.*;

import static baseball.BallStatus.BALL;
import static baseball.BallStatus.STRIKE;

public class BallGame {

    private final List<Ball> systemBallsList;

    BallGame(BallsGenerator ballsGenerator) {
        this.systemBallsList = ballsGenerator.getSystemBallsList();
    }

    public int countMatchToStrike(UserBalls userBalls) {
        int sum = 0;
        for (Ball userBall : userBalls.getUserBallList()) {
            if (matchToStrike(userBall).equals(STRIKE)) {
                sum += 1;
            }
        }
        return sum;
    }

//        return userBalls.getUserBallList()
//                .stream()
//                .filter(userBall -> matchToStrike(userBall).equals(BallStatus.STRIKE))
//                .mapToInt(o ->1)
//                .sum();

    public int countMatchToBall(UserBalls userBalls) {
        int sum = 0;
        for (Ball userBall : userBalls.getUserBallList()) {
            if (matchToBall(userBall).equals(BALL)) {
                sum += 1;
            }
        }
        return sum;
    }
//        return userBalls.getUserBallList().stream()
//                .filter(userBall -> matchToStrike(userBall).equals(BallStatus.BALL))
//                .mapToInt(o -> 1)
//                .sum();
//    }

    //하나의 Game에서 사용자는 반복해 맞추나, 컴퓨터는 유지
    //정리 필요!! this not in Static content
    public BallStatus matchToStrike(Ball userBall) {
        return systemBallsList.stream()
                .filter(ball -> ball.equals(userBall))
                .findFirst()
                .map(o -> STRIKE)
                .orElse(BallStatus.NOTHING);
    }

    public BallStatus matchToBall(Ball userBall) {
        return systemBallsList.stream()
                .filter(ball -> !ball.isSameSlotOf(userBall) && ball.isSameNumOf(userBall))
                .findFirst()
                .map(o -> BALL)
                .orElse(BallStatus.NOTHING);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallGame ballGame = (BallGame) o;
        return Objects.equals(systemBallsList, ballGame.systemBallsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(systemBallsList);
    }


}
