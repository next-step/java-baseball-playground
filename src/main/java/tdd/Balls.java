package tdd;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {
    List<Ball> balls;

    public Balls(List<Integer> balls) {
        isValid(balls);
        this.balls = mapBalls(balls);
    }

    private static List<Ball> mapBalls(List<Integer> balls) {
        return IntStream.range(0, balls.size())
                .mapToObj(i -> new Ball(i + 1, balls.get(i)))
                .collect(Collectors.toList());
    }

    private void isValid(List<Integer> balls) {
        if (balls.size() != 3) {
            throw new IllegalArgumentException("잘못 입력");
        }
    }

    public BallStatus play(Ball ball) {
        return this.balls.stream()
                .map(answer -> answer.play(ball))
                .filter(ballStatus -> ballStatus != BallStatus.NOTHING)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public PlayerResult play(List<Integer> userInput){
        List<Ball> mappedBalls = mapBalls(userInput);
        PlayerResult result = new PlayerResult();
        for (Ball mappedBall : mappedBalls) {
            result.report(play(mappedBall));
        }
        return result;
    }
}
