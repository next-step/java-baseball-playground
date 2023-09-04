import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallTest {

    @Test
    void constructBallTest() {
        Ball ball1 = new Ball(1,2);
        assertEquals(ball1.getPosition(),1);
        assertEquals(ball1.getNumber(),2);
    }
}
