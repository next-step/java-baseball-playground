package study;

import baseball.Ball;
import baseball.BallStatus;
import baseball.Balls;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallsTest {

    @Test
    void nothing(){
        Balls balls = new Balls(Arrays.asList(1,2,3));
        BallStatus status = balls.compare(new Ball(1,4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball(){
        Balls balls = new Balls(Arrays.asList(1,2,3));
        BallStatus status = balls.compare(new Ball(1,3));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike(){
        Balls balls = new Balls(Arrays.asList(1,2,3));
        BallStatus status = balls.compare(new Ball(1,1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }
}
