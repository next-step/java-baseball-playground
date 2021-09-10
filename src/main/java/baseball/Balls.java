package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    List<Ball> balls;

    public Balls(List<Integer> answer) {
        this.balls = mapToBall(answer);
    }

    public PlayResult play(List<Ball> balls){
        PlayResult playResult = new PlayResult();
        for(Ball ball : balls){
            BallStatus ballStatus = this.play(ball);
            playResult.play(ballStatus);
        }
        return playResult;
    }

    public BallStatus play(Ball ball) {
        return balls.stream()
                .map(ball1 -> ball1.play(ball))
                .filter(status -> status!=BallStatus.NOTHING)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    private List<Ball> mapToBall(List<Integer> answer){
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < answer.size(); i++) {
            balls.add(new Ball(i+1, answer.get(i)));
        }
        return balls;
    }

}
