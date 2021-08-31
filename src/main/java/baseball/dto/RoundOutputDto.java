package baseball.dto;

public class RoundOutputDto {

    private static final int ZERO = 0;

    private final int strike;
    private final int ball;
    private final boolean isThreeOut;

    public RoundOutputDto(final int strike, final int ball, final boolean isThreeOut) {
        this.strike = strike;
        this.ball = ball;
        this.isThreeOut = isThreeOut;
    }

    public static RoundOutputDto of(final int strike, final int ball) {
        boolean isThreeOut = areStrikesAndBallsZero(strike, ball);
        return new RoundOutputDto(strike, ball, isThreeOut);
    }

    private static boolean areStrikesAndBallsZero(final int strike, final int ball) {
        return strike == ZERO && ball == ZERO;
    }

    public int ball() {
        return ball;
    }

    public int strike() {
        return strike;
    }

    public boolean isThreeOut() {
        return isThreeOut;
    }
}
