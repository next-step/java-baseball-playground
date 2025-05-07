package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private static final int PLAY_AGAIN = 1;

    private final List<Ball> answers;

    public Balls(List<Integer> answers) {
        if (!ValidationUtils.ValidNoList(answers)) {
            throw new IllegalArgumentException("입력한 수를 다시 확인해 주세요.");
        }

        this.answers = mapBall(answers);
    }

    private static List<Ball> mapBall(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < answers.size(); i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }

        return balls;
    }


    public PlayResult play(List<Integer> balls) {
        Balls userBalls = new Balls(balls);

        PlayResult result = new PlayResult();
        for (Ball answer : answers) {
            BallStatus status = userBalls.play(answer);

            result.report(status);
        }

        return result;
    }

    public BallStatus play(Ball userBall) {
        return answers.stream()
                .map(answer -> answer.play(userBall))
                .filter(status -> status != BallStatus.NOTHING)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public boolean again(int input) {
        if (input == PLAY_AGAIN) {
            return true;
        }

        return false;
    }
}
