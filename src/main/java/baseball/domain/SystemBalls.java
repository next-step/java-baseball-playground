package baseball.domain;

import java.util.*;

import static baseball.domain.BallStatus.*;

public class SystemBalls {

    private final List<Ball> systemBallsList;

    SystemBalls(BallsGenerator ballsGenerator) {
        this.systemBallsList = ballsGenerator.getSystemBallsList();
    }

    public List<Ball> getSystemBallsList() {
        return systemBallsList;
    }

    public BallGameResult match(UserBalls userBalls) {
        BallGameResult ballGameResult = new BallGameResult();
        for (Ball userBall : userBalls.getUserBallList()) {
            if (matchToStrike(userBall).equals(STRIKE)) {
                ballGameResult.addCount(STRIKE);}
            if (matchToBall(userBall).equals(BALL)) {
                ballGameResult.addCount(BALL);}
            }
        return ballGameResult;
    }

    //하나의 Game에서 사용자는 반복해 맞추나, 컴퓨터는 유지
    //정리 필요!! this not in Static content
    private BallStatus matchToStrike(Ball userBall) {
        return systemBallsList.stream()
                .filter(ball -> ball.equals(userBall))
                .findFirst()
                .map(o -> STRIKE)
                .orElse(BallStatus.NOTHING);
    }

    private BallStatus matchToBall(Ball userBall) {
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
        SystemBalls systemBalls = (SystemBalls) o;
        return Objects.equals(systemBallsList, systemBalls.systemBallsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(systemBallsList);
    }
}

//Stream filter  mapToInt(o -> 1).sum() returns Long 다시 고민
//countMathToStrike, countMatchToBall no needed sum +1 for if
//    private int countMatchToStrike(UserBalls userBalls) {
//        int sum = 0;
//        for (Ball userBall : userBalls.getUserBallList()) {
//            if (matchToStrike(userBall).equals(STRIKE)) {
//                sum += 1;
//            }
//        }
//        return sum;
//    }
//
//    private int countMatchToBall(UserBalls userBalls) {
//        int sum = 0;
//        for (Ball userBall : userBalls.getUserBallList()) {
//            if (matchToBall(userBall).equals(BALL)) {
//                sum += 1;
//            }
//        }
//        return sum;
//    }
