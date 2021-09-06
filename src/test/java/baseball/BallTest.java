package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BallTest {

    Ball comBall;

    @BeforeEach
    void setUp(){
        comBall = new Ball(1, 1);
    }

    @Test
    void play(){
        assertThat(comBall.play(1, 1)).isEqualTo(BallStatus.STRIKE);
        assertThat(comBall.play(2, 1)).isEqualTo(BallStatus.BALL);
        assertThat(comBall.play(4, 2)).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void strike(){
        assertThat(comBall.play(1, 1)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball(){
        assertThat(comBall.play(2, 1)).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing(){
        assertThat(comBall.play(4, 2)).isEqualTo(BallStatus.NOTHING);
    }

}
