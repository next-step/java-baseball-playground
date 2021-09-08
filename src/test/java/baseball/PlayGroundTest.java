package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayGroundTest {

    Balls balls;

    @BeforeEach
    void set_up(){
        balls = new Balls(Arrays.asList(new Ball(1, 1), new Ball(2, 2), new Ball(3, 3)));
    }

    @Test
    void play_game(){
        PlayGround playGround = new PlayGround(balls);
        playGround.play(Arrays.asList(new Ball(1, 1), new Ball(2, 2), new Ball(3, 3)));

        assertThat(playGround.getStrike()).isEqualTo(3);
    }
}
