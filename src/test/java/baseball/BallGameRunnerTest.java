package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class BallGameRunnerTest {
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

    @DisplayName("Is 3 Strike BallGameRunner")
    @Test
    void is_3_Strikes_BallGameRunner(){
        String input = "357";
        BallGameRunner ballGameRunner = new BallGameRunner(ballGame, input);
        assertThat(ballGameRunner.getUserballs().getUserBallList()).containsExactly(
                new Ball(new BallNum("3"), 1),
                new Ball(new BallNum("5"), 2),
                new Ball(new BallNum("7"), 3));
        assertThat(ballGameRunner.getBallRecord().findBallStatusCount(BallStatus.STRIKE)).isEqualTo(0);
        assertThat(ballGameRunner.getBallRecord().findBallStatusCount(BallStatus.BALL)).isEqualTo(0);
        assertThat(ballGameRunner.getBallRecord().findBallStatusCount(BallStatus.NOTHING)).isEqualTo(0);

        ballGameRunner.run();

        assertThat(ballGameRunner.getBallRecord().findBallStatusCount(BallStatus.STRIKE)).isEqualTo(3);
        assertThat(ballGameRunner.getBallRecord().findBallStatusCount(BallStatus.BALL)).isEqualTo(0);
        assertThat(ballGameRunner.getBallRecord().findBallStatusCount(BallStatus.NOTHING)).isEqualTo(0);
        HashMap<BallStatus, Integer> expectedStrikeMap = new HashMap<>();
        expectedStrikeMap.put(BallStatus.STRIKE, 3);
        HashMap<BallStatus, Integer> expectedBallMap = new HashMap<>();
        expectedBallMap.put(BallStatus.BALL, 0);
        assertThat(ballGameRunner.getBallRecord().getStatusMapList().contains(expectedStrikeMap)).isTrue();
        assertThat(ballGameRunner.getBallRecord().getStatusMapList().contains(expectedBallMap)).isTrue();
    }

    @DisplayName("Is 1 Strike 2 Balls BallGameRunner")
    @Test
    void is_1_Strike_2_Balls_BallGameRunner(){
        String input = "375";
        BallGameRunner ballGameRunner = new BallGameRunner(ballGame, input);
        assertThat(ballGameRunner.getUserballs().getUserBallList()).containsExactly(
                new Ball(new BallNum("3"), 1),
                new Ball(new BallNum("7"), 2),
                new Ball(new BallNum("5"), 3));
        assertThat(ballGameRunner.getBallRecord().findBallStatusCount(BallStatus.STRIKE)).isEqualTo(0);
        assertThat(ballGameRunner.getBallRecord().findBallStatusCount(BallStatus.BALL)).isEqualTo(0);
        assertThat(ballGameRunner.getBallRecord().findBallStatusCount(BallStatus.NOTHING)).isEqualTo(0);

        ballGameRunner.run();

        assertThat(ballGameRunner.getBallRecord().findBallStatusCount(BallStatus.STRIKE)).isEqualTo(1);
        assertThat(ballGameRunner.getBallRecord().findBallStatusCount(BallStatus.BALL)).isEqualTo(2);
        assertThat(ballGameRunner.getBallRecord().findBallStatusCount(BallStatus.NOTHING)).isEqualTo(0);
        HashMap<BallStatus, Integer> expectedStrikeMap = new HashMap<>();
        expectedStrikeMap.put(BallStatus.STRIKE, 1);
        HashMap<BallStatus, Integer> expectedBallMap = new HashMap<>();
        expectedBallMap.put(BallStatus.BALL, 2);
        assertThat(ballGameRunner.getBallRecord().getStatusMapList().contains(expectedStrikeMap)).isTrue();
        assertThat(ballGameRunner.getBallRecord().getStatusMapList().contains(expectedBallMap)).isTrue();
    }

    @DisplayName("Is Nothing BallGameRunner")
    @Test
    void is_Nothing_BallGameRunner(){
        String input = "248";
        BallGameRunner ballGameRunner = new BallGameRunner(ballGame, input);
        assertThat(ballGameRunner.getUserballs().getUserBallList()).containsExactly(
                new Ball(new BallNum("2"), 1),
                new Ball(new BallNum("4"), 2),
                new Ball(new BallNum("8"), 3));
        assertThat(ballGameRunner.getBallRecord().findBallStatusCount(BallStatus.STRIKE)).isEqualTo(0);
        assertThat(ballGameRunner.getBallRecord().findBallStatusCount(BallStatus.BALL)).isEqualTo(0);
        assertThat(ballGameRunner.getBallRecord().findBallStatusCount(BallStatus.NOTHING)).isEqualTo(0);

        ballGameRunner.run();

        assertThat(ballGameRunner.getBallRecord().findBallStatusCount(BallStatus.STRIKE)).isEqualTo(0);
        assertThat(ballGameRunner.getBallRecord().findBallStatusCount(BallStatus.BALL)).isEqualTo(0);
        assertThat(ballGameRunner.getBallRecord().findBallStatusCount(BallStatus.NOTHING)).isEqualTo(1);
        HashMap<BallStatus, Integer> expectedStrikeMap = new HashMap<>();
        expectedStrikeMap.put(BallStatus.STRIKE, 0);
        HashMap<BallStatus, Integer> expectedNothingMap = new HashMap<>();
        expectedNothingMap.put(BallStatus.NOTHING, 1);
        assertThat(ballGameRunner.getBallRecord().getStatusMapList().contains(expectedStrikeMap)).isTrue();
        assertThat(ballGameRunner.getBallRecord().getStatusMapList().contains(expectedNothingMap)).isTrue();
    }
}
