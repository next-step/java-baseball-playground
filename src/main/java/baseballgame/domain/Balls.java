package baseballgame.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> answer;

    public Balls(List<Integer> ballList) {
        this.answer = MapBall(ballList);
    }

    private List<Ball> MapBall(List<Integer> ballList) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball((i + 1), ballList.get(i)));
        }
        return balls;
    }

    public PlayResult play(List<Integer> inputBalls){
        Balls playerBalls = new Balls(inputBalls);
        PlayResult result = new PlayResult();
        for(Ball answer : answer){
            BallStatus status = playerBalls.play(answer);
            result.report(status);
        }
        return result;
    }


    public BallStatus play(Ball userBall) {
        return answer.stream()
                .map(answer -> answer.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);

    }


}
