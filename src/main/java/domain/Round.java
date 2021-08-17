package domain;

import dto.RoundOutputDto;

public class Round {
    public static final int ENOUGH_STRIKE_INCLUSIVE = 3;
    private Balls balls;
    private boolean isOver;

    public Round(final Balls balls, final boolean isOver) {
        this.balls = balls;
        this.isOver = isOver;
    }

    public static Round from(Balls balls) {
        return new Round(balls, false);
    }
    
    public RoundOutputDto countResult(Balls userInput) {
        int strike = balls.countSameNumberWithSamePosition(userInput);
        int ball = balls.countSameNumberWithDifferentPosition(userInput);
        areEnoughStrikes(strike);
        return RoundOutputDto.of(strike, ball);
    }

    private void areEnoughStrikes(final int strike) {
        if (strike == ENOUGH_STRIKE_INCLUSIVE) {
            isOver = true;
        }
    }

    public boolean isOver() {
        return isOver;
    }
}
