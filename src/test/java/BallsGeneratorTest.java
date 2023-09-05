import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallsGeneratorTest {

    private BallsGenerator ballsGenerator;

    @BeforeEach
    void setUp() {
        ballsGenerator = new BallsGenerator();
    }

    @Test
    void makeRandomBallsTest() {
        Balls balls = ballsGenerator.makeRandomBalls(3);
        assertEquals(balls.getBalls().size(),3);
    }
}
