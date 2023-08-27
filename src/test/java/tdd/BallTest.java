package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    static Ball comBall;
    @BeforeEach
    void comBall(){
        comBall = new Ball(1,1);
    }
    @Test
    void nothing(){
        Ball userBall = new Ball(1,9);
        assertThat(comBall.play(userBall)).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball(){
        Ball userBall = new Ball(2,1);
        assertThat(comBall.play(userBall)).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike(){
        Ball userBall = new Ball(1,1);
        assertThat(comBall.play(userBall)).isEqualTo(BallStatus.STRIKE);
    }
}
