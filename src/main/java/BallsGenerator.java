import java.util.Random;

public class BallsGenerator {
    public Balls makeRandomBalls(int size) {
        Balls balls = new Balls();
        Random rd = new Random();
        while(balls.getBalls().size() < size) {
            balls.addBall(rd.nextInt(9)+1);
        }
        return balls;
    }
}
