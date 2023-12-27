package baseball.model;

public class Referee {
    private static int strike = 0;
    private static int ball = 0;

    public Referee(BaseballNumbers computer, BaseballNumbers user) {
        countBall(computer, user);
        countStrike(computer, user);
    }

    public static int getBall() {
        return ball;
    }

    public static int getStrike() {
        return strike;
    }

    private int countBall(BaseballNumbers computer, BaseballNumbers user) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computer.getNumbers().get(i).getNumber() == user.getNumbers().get(j).getNumber()) {
                    if (i != j) {
                        ball++;
                    }
                }
            }
        }
        return ball;
    }

    private int countStrike(BaseballNumbers computer, BaseballNumbers user) {
        for (int i = 0; i < 3; i++) {
            if (computer.getNumbers().get(i).getNumber() == user.getNumbers().get(i).getNumber()) {
                strike++;
            }
        }
        return strike;
    }

    public void resetBallStrikeCount() {
        ball = 0;
        strike = 0;
    }
}