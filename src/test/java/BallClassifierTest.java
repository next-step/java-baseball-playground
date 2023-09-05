import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BallClassifierTest {
    /**
     * [테스트할 내용]
     *     3-1. 위치 O, 숫자포함 O -> 스트라이크 - BallClassifier#isStrike
     *     3-2. 위치 X, 숫자포함 O -> 볼 - BallClassifier#isBall
     *     3-3. 위치 X, 숫자포함 X -> 낫싱 - BallClassifier#isNothing
     */

    BallClassifier ballClassifier = null;

    private Balls _makeTestBalls() {
        List<Ball> testBalls = new ArrayList<>();
        testBalls.add(new Ball(1,2));
        testBalls.add(new Ball(2,3));
        testBalls.add(new Ball(3,4));
        return new Balls(testBalls);
    }


    @BeforeEach
    void setUp() {
        ballClassifier = new BallClassifier();
    }

    @Test
    void strikeCheckTrue() {
        Balls testBalls = _makeTestBalls();
        Ball ball = new Ball(1,2);
        assertTrue(ballClassifier.isStrike(testBalls, ball));
    }

    @Test
    void strikeCheckFalse() {
        Balls testBalls = _makeTestBalls();
        Ball ball = new Ball(1,3);
        assertFalse(ballClassifier.isStrike(testBalls, ball));
    }
}
