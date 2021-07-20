package baseball.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static baseball.domain.BallNum.BALLS_POOL;

public class BallsGenerator {


    private final List<Ball> systemBallsList;

    public BallsGenerator(List<Ball> systemBallsList) {
        this.systemBallsList = systemBallsList;
    }

    public BallsGenerator() {
         this.systemBallsList = makeRandomBalls();
    }

    private List<Ball> makeRandomBalls() {
        Collections.shuffle(BALLS_POOL);
        return Arrays.asList(new Ball(new BallNum(BALLS_POOL.get(0)), 1),
                new Ball(new BallNum(BALLS_POOL.get(1)), 2),
                new Ball(new BallNum(BALLS_POOL.get(2)), 3));
    }

    public List<Ball> getSystemBallsList() {
        return systemBallsList;
    }

}
