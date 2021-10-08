package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Balls {
    public List<Ball> answer = new ArrayList<>();

    public Balls(List<Integer> input) {
        for (int i = 0; i < 3; i++) {
            this.answer.add(new Ball(i + 1, input.get(i)));
        }
    }

    public static List<Integer> validate(Balls com, Balls user) {
        List<BallStatus> result = new ArrayList<>();

        for (Ball userBall : user.answer) {
            result.addAll(com.validateUserBall(userBall));
        }

        int strike = (int) result.stream().filter(status -> status == BallStatus.STRIKE).count();
        int ball = (int) result.stream().filter(status -> status == BallStatus.BALL).count();

        return Arrays.asList(strike, ball);
    }

    public List<BallStatus> validateUserBall(Ball ball) {
        List<BallStatus> result = new ArrayList<>();

        for (Ball comBall : answer) {
            result.add(comBall.validateStatus(ball));
        }

        return result;
    }
}
