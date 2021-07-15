package baseball;

import java.util.*;

import static baseball.BallStatus.BALL;
import static baseball.BallStatus.STRIKE;

public class BallGame {

    private final List<Ball> systemBallsList;
    private final BallRecord ballRecord;

    BallGame(BallsGenerator ballsGenerator) {
        this.systemBallsList = ballsGenerator.getSystemBallsList();
        this.ballRecord = new BallRecord();
    }

    public List<Ball> getSystemBallsList() {
        return systemBallsList;
    }

    public BallRecord getBallRecord() {
        return ballRecord;
    }

//    public int findBallRecordOf(BallStatus ballStatus) {
//        return this.ballRecord.findBallStatusCount(ballStatus);
//    }

    //Stream filter  mapToInt(o -> 1).sum() returns Long 다시 고민
    public int countMatchToStrike(UserBalls userBalls) {
        int sum = 0;
        for (Ball userBall : userBalls.getUserBallList()) {
            if (matchToStrike(userBall).equals(STRIKE)) {
                sum += 1;
            }
        }
        return sum;
    }

    public int countMatchToBall(UserBalls userBalls) {
        int sum = 0;
        for (Ball userBall : userBalls.getUserBallList()) {
            if (matchToBall(userBall).equals(BALL)) {
                sum += 1;
            }
        }
        return sum;
    }

    //boolean isNothing or int(count) countToNothing
    public int countMatchToNothing(UserBalls userBalls){
       if (countMatchToStrike(userBalls)== 0 && countMatchToBall(userBalls) == 0) {
           return 1;
       }
       return 0;
    }


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
        return Objects.equals(systemBallsList, ballGame.systemBallsList) &&
                Objects.equals(ballRecord, ballGame.ballRecord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(systemBallsList, ballRecord);
    }
}
