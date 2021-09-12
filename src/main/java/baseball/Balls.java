package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    List<Ball> balls;

    public Balls(List<Integer> answer) {
        this.balls = mapToBall(answer);
    }

    public PlayResult play(Balls balls){
        PlayResult playResult = new PlayResult();
        for(Ball ball : balls.getBalls()){
            BallStatus ballStatus = this.play(ball);
            playResult.play(ballStatus);
        }
        return playResult;
    }

    public BallStatus play(Ball ball) {
        return this.balls.stream()
                .map(it -> it.play(ball))
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

    public List<Ball> getBalls() {
        return balls;
    }
}
