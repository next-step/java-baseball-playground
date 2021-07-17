package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallGameTest {

    private BallGame ballGame;
    //as a private field and add
    //why not work?

    @BeforeEach
    void setUp(){
        BallsGenerator ballsGenerator = new BallsGenerator(Arrays.asList(
            new Ball(new BallNum("3"), 1),
            new Ball(new BallNum("5"), 2),
            new Ball(new BallNum("7"), 3)
        ));
        ballGame = new BallGame(ballsGenerator);
    }

    @DisplayName("3 Strikes for UserBall")
    @Test
    void is_3_Strikes() {
        UserBalls userBalls = new UserBalls("357");

        assertThat(ballGame.countMatchToStatus(userBalls, BallStatus.STRIKE)).isEqualTo(3);
        assertThat(ballGame.countMatchToStatus(userBalls, BallStatus.BALL)).isEqualTo(0);
        assertThat(ballGame.countMatchToStatus(userBalls, BallStatus.NOTHING)).isEqualTo(0);
    }

    @DisplayName("1 Strike 2 Balls for UserBall")
    @Test
    void is_1_Strike_2_Balls() {
        UserBalls userBalls = new UserBalls("375");

        assertThat(ballGame.countMatchToStatus(userBalls, BallStatus.STRIKE)).isEqualTo(1);
        assertThat(ballGame.countMatchToStatus(userBalls, BallStatus.BALL)).isEqualTo(2);
        assertThat(ballGame.countMatchToStatus(userBalls, BallStatus.NOTHING)).isEqualTo(0);
    }

    @DisplayName("1 Strike 1 Ball for UserBall")
    @Test
    void is_1_Strike_1_Ball() {
        UserBalls userBalls = new UserBalls("587");

        assertThat(ballGame.countMatchToStatus(userBalls, BallStatus.STRIKE)).isEqualTo(1);
        assertThat(ballGame.countMatchToStatus(userBalls, BallStatus.BALL)).isEqualTo(1);
        assertThat(ballGame.countMatchToStatus(userBalls, BallStatus.NOTHING)).isEqualTo(0);
        
    }

    @DisplayName("3 Balls for UserBall")
    @Test
    void is_3_Balls() {
        UserBalls userBalls = new UserBalls("573");

        assertThat(ballGame.countMatchToStatus(userBalls, BallStatus.STRIKE)).isEqualTo(0);
        assertThat(ballGame.countMatchToStatus(userBalls, BallStatus.BALL)).isEqualTo(3);
        assertThat(ballGame.countMatchToStatus(userBalls, BallStatus.NOTHING)).isEqualTo(0);
    }

    @DisplayName("Nothing")
    @Test
    void is_Nothing() {
        UserBalls userBalls = new UserBalls("248");

        assertThat(ballGame.countMatchToStatus(userBalls, BallStatus.STRIKE)).isEqualTo(0);
        assertThat(ballGame.countMatchToStatus(userBalls, BallStatus.BALL)).isEqualTo(0);
        assertThat(ballGame.countMatchToStatus(userBalls, BallStatus.NOTHING)).isEqualTo(1);
    }

   //matchToStrike(UserBall), matchToBall(UserBall)  turned to Private Function
}
