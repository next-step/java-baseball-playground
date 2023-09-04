import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class Balls {
    private List<Ball> balls;

    public Balls() {
        balls = new ArrayList<>();
    }

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public void addBall(Integer ballNumber) {
        if(!isDuplicateBall(ballNumber)) {
            Ball newBall = new Ball(this.balls.size()+1, ballNumber);
            this.balls.add(newBall);
        }
    }

    public boolean isDuplicateBall(Integer ballNumber) {
        return this.balls.stream()
                .anyMatch(ball -> ball.getNumber() == ballNumber);
    }
}
