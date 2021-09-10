package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayResultTest {

    Balls balls;

    @BeforeEach
    void set_up(){
        balls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void play(){
        PlayResult playResult = balls.play(Arrays.asList(new Ball(1, 1), new Ball(2, 2), new Ball(3, 3)));
        playResult.printResult();
    }

    @Test
    void play_2strike_1ball(){
        PlayResult playResult = balls.play(Arrays.asList(new Ball(1, 1), new Ball(2, 2), new Ball(2, 3)));
        assertThat(playResult.getStrike()).isEqualTo(2);
        assertThat(playResult.getBall()).isEqualTo(1);
    }
}
