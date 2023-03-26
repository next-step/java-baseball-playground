package baesballgame.model.computer.dto;

public class ResponseResult {

    private int ball;
    private int strike;

    public ResponseResult(final int ball, final int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}