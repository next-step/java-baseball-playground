package baseball;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static baseball.BallNum.BALLS_POOL;

public class BallsGenerator {

    private final List<Ball> systemBallsList;

    public BallsGenerator(List<Ball> ballList) {
        this.systemBallsList = ballList;
    }

//    public BallsGenerator() {
//        this.systemBallsList = makeRandomBalls();
//    }
//
//
//    private List<Ball> makeRandomBalls() {
//        Collections.shuffle(BALLS_POOL);
//        return Arrays.asList(new Ball(new BallNum(BALLS_POOL.get(0)), 1),
//                new Ball(new BallNum(BALLS_POOL.get(1)), 2),
//                new Ball(new BallNum(BALLS_POOL.get(2)), 3);
//    }

    public List<Ball> getSystemBallsList() {
        return systemBallsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallsGenerator that = (BallsGenerator) o;
        return Objects.equals(systemBallsList, that.systemBallsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(systemBallsList);
    }

}
