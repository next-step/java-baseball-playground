package study.baseball;

import lombok.AllArgsConstructor;

import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Stream;

@AllArgsConstructor
public class Balls {
    private final List<Ball> ballList;

    public Balls() {
        ballList = new ArrayList<>();
    }

    public Balls makeRandomBalls() {
        SecureRandom secureRandom = new SecureRandom();
        List<Ball> balls = new ArrayList<>();
        int index = 0;
        while (balls.size() < 3) {
            balls.add(new Ball(secureRandom.nextInt(9) + 1, index++));
        }
        return new Balls(balls);
    }

    public List<Ball> balls() {
        return ballList;
    }

    public int size() {
        return this.ballList.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balls balls1 = (Balls) o;
        return Objects.equals(ballList, balls1.ballList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballList);
    }

    @Override
    public String toString() {
        return  ballList.get(0).toString() + ballList.get(1).toString()+ ballList.get(2).toString();
    }
}
