package study;

import baseball.Ball;
import baseball.BallStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallTest {

    private Ball computerBall;

    @BeforeEach
    void setUp(){
        computerBall = new Ball(1,1);
    }

    @Test
    void strike(){
        Ball userBall = new Ball(1,1);
        assertThat(computerBall.play(userBall)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball(){
        Ball userBall = new Ball(2,1);
        assertThat(computerBall.play(userBall)).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing(){
        Ball userBall = new Ball(3,3);
        assertThat(computerBall.play(userBall)).isEqualTo(BallStatus.NOTHING);
    }
}
