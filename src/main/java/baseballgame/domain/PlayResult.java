package baseballgame.domain;

public class PlayResult {
    int strike = 0;
    int ball = 0;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void report(BallStatus status) {
        if(status.isStrike()){
            strike++;
        }
        if(status.isBall()){
            ball++;
        }
    }

    public boolean isGameEnd() {
        return this.strike == 3;
    }



}
