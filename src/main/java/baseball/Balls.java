package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> balls; // computer balls

    public Balls(List<Integer> computer) {
        this.balls = getBalls(computer);
    }


    private static List<Ball> getBalls(List<Integer> computer) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i+1, computer.get(i)));
        }
        return balls;
    }
    public Score play(List<Integer> userInput) {
        Balls userBalls = new Balls(userInput);
        Score result = new Score();
        // 비교 분석
        for(Ball answer : balls){ // computerBall
            BallStatus status = userBalls.playBalls(answer); // 앞 뒤에 들어갈 객체가 바뀌어도 strike,ball 판별에는 문제가 되지 않음
            result.report(status);
        }
        return result;
    }

    public BallStatus playBalls(Ball userBall) {
        return balls.stream()
                .map(answer -> answer.playBall(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
