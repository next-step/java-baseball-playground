package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {
    static Balls balls;
    @BeforeEach
    void setBall(){
        balls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void play_1Ball1Strike(){
        PlayerResult result = balls.play(Arrays.asList(1,3,6));
        assertThat(result.getBall()).isEqualTo(1);
        assertThat(result.getStrike()).isEqualTo(1);
    }
    @Test
    void play_Nothing(){
        PlayerResult result = balls.play(Arrays.asList(4,5,6));
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(0);
    }
    @Test
    void nothing(){
        Ball ball = new Ball(1, 9);
        BallStatus status = balls.play(ball);
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball(){
        Ball ball = new Ball(1, 3);
        assertThat(balls.play(ball)).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike(){
        Ball ball = new Ball(1, 1);
        assertThat(balls.play(ball)).isEqualTo(BallStatus.STRIKE);
    }
}
