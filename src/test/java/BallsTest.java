import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BallsTest {
    private Balls balls = null;

    private Balls _makeTestBalls() {
        List<Ball> testBalls = new ArrayList<>();
        testBalls.add(new Ball(1,2));
        testBalls.add(new Ball(2,3));
        testBalls.add(new Ball(3,4));
        return new Balls(testBalls);
    }
    @BeforeEach
    void setUp() {
        balls = new Balls();
    }

    @Test
    void duplicateTest() {
        balls = _makeTestBalls();
        assertTrue(balls.isDuplicateBall(2));
        assertFalse(balls.isDuplicateBall(1));
    }

    @Test
    void duplicateBallsTest() {
        balls.addBall(2);
        balls.addBall(2);
        balls.addBall(2);

        assertEquals(balls.getBalls().size(),1);
    }

    @Test
    void uniqueBallsTest() {
        balls.addBall(1);
        balls.addBall(2);
        balls.addBall(3);

        assertEquals(balls.getBalls().size(),3);
    }
}
