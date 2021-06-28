package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class BallTest {
    @Test
    void testWithBall() {
        // Given
        Ball computer = new Ball(0, 2);
        Ball answer = new Ball(1, 2);
        List<Ball> computerList = Arrays.asList(computer);

        // When
        ResultType type = answer.getStatus(computerList);

        // Then
        Assertions.assertEquals(type, ResultType.BALL);
    }

    @Test
    void testWithStrike() {
        // Given
        Ball computer = new Ball(1, 2);
        Ball answer = new Ball(1, 2);
        List<Ball> computerList = Arrays.asList(computer);

        // When
        ResultType type = answer.getStatus(computerList);

        // Then
        Assertions.assertEquals(type, ResultType.STRIKE);
    }

    @Test
    void testWithNothing() {
        // Given
        Ball computer = new Ball(1, 3);
        Ball answer = new Ball(1, 2);
        List<Ball> computerList = Arrays.asList(computer);

        // When
        ResultType type = answer.getStatus(computerList);

        // Then
        Assertions.assertEquals(type, ResultType.NOTHING);
    }
}
