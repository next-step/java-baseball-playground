package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallStatusTest {

    private List<Ball> systemBallList;

    //as a private field and add
    //why not work?
//    @BeforeEach
//    void setUp() {
//        systemBallList = new ArrayList<>();
//        //list.add(index, value) VS set.add(value)
//        systemBallList.add(0, new Ball(new BallNum("3"), 1));
//        systemBallList.add(1, new Ball(new BallNum("5"), 2));
//        systemBallList.add(2, new Ball(new BallNum("7"), 3));
//
//    }


    @DisplayName("Strike for One Ball")
    @Test
    void isStrike() {
        BallsGenerator ballsGenerator = new BallsGenerator(Arrays.asList(
                new Ball(new BallNum("3"), 1),
                new Ball(new BallNum("5"), 2),
                new Ball(new BallNum("7"), 3)
        ));
        BallGame ballGame = new BallGame(ballsGenerator);

        Ball usrBall1 = new Ball(new BallNum("3"), 1);
        Ball usrBall2 = new Ball(new BallNum("5"), 2);

        assertThat(ballGame.matchToStrike(usrBall1)).isEqualTo(BallStatus.STRIKE);
        assertThat(ballGame.matchToStrike(usrBall2)).isEqualTo(BallStatus.STRIKE);
        assertThat(ballGame.matchToBall(usrBall1)).isEqualTo(BallStatus.NOTHING);
        assertThat(ballGame.matchToBall(usrBall2)).isEqualTo(BallStatus.NOTHING);
    }

    @DisplayName("Ball for One Ball")
    @Test
    void isBall() {
        BallsGenerator ballsGenerator = new BallsGenerator(Arrays.asList(
                new Ball(new BallNum("3"), 1),
                new Ball(new BallNum("5"), 2),
                new Ball(new BallNum("7"), 3)
        ));
        BallGame ballGame = new BallGame(ballsGenerator);
        Ball usrBall1 = new Ball(new BallNum("3"), 2);
        Ball usrBall2 = new Ball(new BallNum("7"), 2);

        assertThat(ballGame.matchToBall(usrBall1)).isEqualTo(BallStatus.BALL);
        assertThat(ballGame.matchToBall(usrBall2)).isEqualTo(BallStatus.BALL);
        assertThat(ballGame.matchToStrike(usrBall1)).isEqualTo(BallStatus.NOTHING);
        assertThat(ballGame.matchToStrike(usrBall2)).isEqualTo(BallStatus.NOTHING);
    }

    @DisplayName("Nothing for One Ball")
    @Test
    void isNothing() {
        BallsGenerator ballsGenerator = new BallsGenerator(Arrays.asList(
                new Ball(new BallNum("3"), 1),
                new Ball(new BallNum("5"), 2),
                new Ball(new BallNum("7"), 3)
        ));
        BallGame ballGame = new BallGame(ballsGenerator);

        Ball usrBall1 = new Ball(new BallNum("4"), 2);
        Ball usrBall2 = new Ball(new BallNum("6"), 2);

        assertThat(ballGame.matchToBall(usrBall1)).isEqualTo(BallStatus.NOTHING);
        assertThat(ballGame.matchToBall(usrBall2)).isEqualTo(BallStatus.NOTHING);
        assertThat(ballGame.matchToStrike(usrBall1)).isEqualTo(BallStatus.NOTHING);
        assertThat(ballGame.matchToStrike(usrBall2)).isEqualTo(BallStatus.NOTHING);
    }

}
