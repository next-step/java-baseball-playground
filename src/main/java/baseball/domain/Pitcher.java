package baseball.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Pitcher {

    public static final int BALL_LENGTH = 3;

    public String throwBall() {
        StringBuilder ball = new StringBuilder();
        while (ball.length() < BALL_LENGTH) {
            addNumber(ball);
        }
        return ball.toString();
    }

    private static void addNumber(StringBuilder ball) {
        int number = pickNumberInRange(1, 9);
        if (ball.toString().contains(String.valueOf(number))) {
            return;
        }
        ball.append(number);
    }
}
