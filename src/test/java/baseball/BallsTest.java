package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    Balls balls;

    @BeforeEach
    void balls_set(){
        balls = new Balls(Arrays.asList(new Ball(1, 1), new Ball(2, 2), new Ball(3, 3)));
    }

    @Test
    void balls_strike(){
        assertThat(balls.play(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void balls_ball(){
        assertThat(balls.play(new Ball(1, 2))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void balls_nothing(){
        assertThat(balls.play(new Ball(1, 10))).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void play_game(){
        PlayResult playResult = balls.play(Arrays.asList(new Ball(1, 2), new Ball(2, 2), new Ball(3, 3)));
        playResult.printResult();
    }
}
