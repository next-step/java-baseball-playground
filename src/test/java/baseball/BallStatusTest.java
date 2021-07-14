package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallStatusTest {


    @DisplayName("Strike for One Ball")
    @Test
    void isStrike() {
        BallsGenerator ballsGenerator = new BallsGenerator(Arrays.asList(
                new Ball(new BallNum("3"), 1),
                new Ball(new BallNum("5"), 2),
                new Ball(new BallNum("7"), 3)
        ));

        Ball usrBall = new Ball(new BallNum("3"), 1);
        BallGame ballGame = new BallGame(ballsGenerator);
        assertThat(ballGame.match(usrBall)).isEqualTo(BallStatus.STRIKE);
    }

    @DisplayName("Ball for One Ball")
    @Test
    void isBall() {
        BallsGenerator ballsGenerator = new BallsGenerator(Arrays.asList(
                new Ball(new BallNum("3"), 1),
                new Ball(new BallNum("5"), 2),
                new Ball(new BallNum("7"), 3)
        ));

        Ball usrBall = new Ball(new BallNum("3"), 2);
        BallGame ballGame = new BallGame(ballsGenerator);
        assertThat(ballGame.match(usrBall)).isEqualTo(BallStatus.BALL);
    }

}
