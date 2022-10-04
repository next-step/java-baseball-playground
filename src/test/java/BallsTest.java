import baseballgame.domain.Ball;
import baseballgame.domain.BallStatus;
import baseballgame.domain.Balls;
import baseballgame.domain.PlayResult;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {
    @Test
    void play_3strike(){
        Balls answers = new Balls(Arrays.asList(1,2,3));
        PlayResult result = answers.play(Arrays.asList(1,2,3));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.isGameEnd()).isTrue();
    }

    @Test
    void play_1Ball_1Strike(){
        Balls answers = new Balls(Arrays.asList(1,2,3));
        PlayResult result = answers.play(Arrays.asList(1,3,5));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void play_nothing(){
        Balls answers = new Balls(Arrays.asList(1,2,3));
        PlayResult result = answers.play(Arrays.asList(4,5,6));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void STRIKE(){
        Balls answers = new Balls(Arrays.asList(1,2,3));
        BallStatus status = answers.play(new Ball(1,1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void BALL(){
        Balls answers = new Balls(Arrays.asList(1,2,3));
        BallStatus status = answers.play(new Ball(1,2));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void NOTHING(){
        Balls answer = new Balls(Arrays.asList(1,2,3));
        BallStatus status = answer.play(new Ball(1,5));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
