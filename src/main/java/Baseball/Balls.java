package Baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private List<Ball> balls;

    public Balls(List<Integer> ballNumbers) {
        if(ballNumbers.size() != 3) {
            throw new IllegalArgumentException("자리수는 세자리만 가능합니다.");
        }
        balls = new ArrayList<>();
        for(int i = 0; i < ballNumbers.size(); i++) {
            balls.add(new Ball(i + 1, ballNumbers.get(i)));
        }
    }

    public BallStatus play(Ball ball) {
        return balls.stream()
                .map(balls -> balls.play(ball))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public PlayResult play(List<Integer> ballNumbers) {
        Balls balls = new Balls(ballNumbers);
        PlayResult playResult = new PlayResult();
        for(Ball ball : this.balls) {
            BallStatus ballStatus = balls.play(ball);
            playResult.report(ballStatus);
        }

        return playResult;
    }

    public PlayResult play(Balls balls) {
        PlayResult playResult = new PlayResult();
        for(Ball ball : this.balls) {
            BallStatus ballStatus = balls.play(ball);
            playResult.report(ballStatus);
        }

        return playResult;
    }
}
