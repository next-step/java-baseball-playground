package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BallStatusTest {

    @DisplayName("Strike for One Ball")
    @Test
    void isStrike() {
        Ball usrBall = new Ball("3", 1);
        Ball comBall = new Ball("3", 1);
        BallGame ballGame = new BallGame(comBall);
        assertThat(ballGame.match(usrBall)).isEqualTo(BallStatus.STRIKE);
    }

    @DisplayName("Ball for One Ball")
    @Test
    void isBall() {
        Ball usrBall = new Ball("3", 2);
        Ball comBall = new Ball("3", 1);
        BallGame ballGame = new BallGame(comBall);
        assertThat(ballGame.match(usrBall)).isEqualTo(BallStatus.BALL);
    }

}
