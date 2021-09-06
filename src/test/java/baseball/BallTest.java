package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BallTest {

    @Test
    void play(){
        Ball comBall = new Ball(1, 1);
        assertThat(comBall.play(1, 1)).isEqualTo(BallStatus.STRIKE);
        assertThat(comBall.play(2, 1)).isEqualTo(BallStatus.BALL);
        assertThat(comBall.play(4, 2)).isEqualTo(BallStatus.NOTING);
    }









}
