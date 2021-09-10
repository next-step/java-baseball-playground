package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayResultTest {

    Balls balls;

    @BeforeEach
    void set_up(){
        balls = new Balls(Arrays.asList(new Ball(1, 1), new Ball(2, 2), new Ball(3, 3)));
    }

    @Test
    void play(){
        PlayResult playResult = balls.play(Arrays.asList(new Ball(1, 1), new Ball(2, 2), new Ball(3, 3)));
        playResult.printResult();
    }
}
