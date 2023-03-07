package study;

import baseball.Ball;
import baseball.BallStatus;
import baseball.Balls;
import baseball.BaseBallResult;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallsTest {

    @Test
    void play_gameOver(){
        Balls computerBalls = new Balls(Arrays.asList(1,2,3));
        Balls userBalls = new Balls(Arrays.asList(1,2,3));
        BaseBallResult result = computerBalls.play(userBalls);
        assertThat(result.isGameOver()).isTrue();
    }
    @Test
    void play_nothing(){
        Balls computerBalls = new Balls(Arrays.asList(1,2,3));
        Balls userBalls = new Balls(Arrays.asList(4,5,6));
        BaseBallResult result = computerBalls.play(userBalls);
        assertThat(result.isNotThing()).isTrue();
    }
    @Test
    void play_one_strike_one_ball(){
        Balls computerBalls = new Balls(Arrays.asList(1,2,3));
        Balls userBalls = new Balls(Arrays.asList(1,3,6));
        BaseBallResult result = computerBalls.play(userBalls);
        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertThat(result.getBallCount()).isEqualTo(1);
    }
    @Test
    void play_one_strike(){
        Balls computerBalls = new Balls(Arrays.asList(1,2,3));
        Balls userBalls = new Balls(Arrays.asList(1,5,6));
        BaseBallResult result = computerBalls.play(userBalls);
        assertThat(result.getStrikeCount()).isEqualTo(1);
    }

    @Test
    void nothing(){
        Balls balls = new Balls(Arrays.asList(1,2,3));
        BallStatus status = balls.compare(new Ball(1,4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball(){
        Balls balls = new Balls(Arrays.asList(1,2,3));
        BallStatus status = balls.compare(new Ball(1,3));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike(){
        Balls balls = new Balls(Arrays.asList(1,2,3));
        BallStatus status = balls.compare(new Ball(1,1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }
}
