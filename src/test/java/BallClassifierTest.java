import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BallClassifierTest {
    /**
     * [테스트할 내용]
     *     3-1. 위치 O, 숫자포함 O -> 스트라이크 - BallClassifier#isStrike
     *     3-2. 위치 X, 숫자포함 O -> 볼 - BallClassifier#isBall
     *     3-3. 위치 X, 숫자포함 X -> 낫싱 - BallClassifier#isNothing
     */

    BallClassifier ballClassifier = null;

    @BeforeEach
    void setUp() {
        ballClassifier = new BallClassifier();
    }

    @Test
    void strikeCheck() {
        assertTrue(ballClassifier.isStrike());
    }
}
