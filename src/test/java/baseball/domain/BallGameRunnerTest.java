package baseball.domain;

import baseball.domain.*;
import baseball.domain.BallStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallGameRunnerTest {
    private SystemBalls systemBalls;
    //as a private field and add
    //why not work?

    @BeforeEach
    void setUp(){
        BallsGenerator ballsGenerator = new BallsGenerator(Arrays.asList(
                new Ball(new BallNum("3"), 1),
                new Ball(new BallNum("5"), 2),
                new Ball(new BallNum("7"), 3)
        ));
        systemBalls = new SystemBalls(ballsGenerator);

    }

    @DisplayName("IsEnd_Run and Get 3 Strikes")
    @Test
    void isEnd_run_3_Strikes() {
        BallGameRunner ballGameRunner = new BallGameRunner(systemBalls, "357");

        assertThat(ballGameRunner.run().getCount(BallStatus.STRIKE)).isEqualTo(3);
        assertThat(ballGameRunner.run().getCount(BallStatus.BALL)).isEqualTo(0);
        assertThat(ballGameRunner.isEnd()).isTrue();
    }

    @DisplayName("Run and Get 1 Strike 2 Balls")
    @Test
    void run_1_Strike_2_Balls() {
        BallGameRunner ballGameRunner = new BallGameRunner(systemBalls, "375");

        assertThat(ballGameRunner.run().getCount(BallStatus.STRIKE)).isEqualTo(1);
        assertThat(ballGameRunner.run().getCount(BallStatus.BALL)).isEqualTo(2);
    }

    @DisplayName("Run and Get 1 Strike 1 Ball")
    @Test
    void run_1_Strike_1_Ball() {
        BallGameRunner ballGameRunner = new BallGameRunner(systemBalls, "587");

        assertThat(ballGameRunner.run().getCount(BallStatus.STRIKE)).isEqualTo(1);
        assertThat(ballGameRunner.run().getCount(BallStatus.BALL)).isEqualTo(1);

    }

    @DisplayName("Run and Get 3 Balls")
    @Test
    void run_3_Balls() {
        BallGameRunner ballGameRunner = new BallGameRunner(systemBalls, "573");

        assertThat(ballGameRunner.run().getCount(BallStatus.STRIKE)).isEqualTo(0);
        assertThat(ballGameRunner.run().getCount(BallStatus.BALL)).isEqualTo(3);
        assertThat(ballGameRunner.isEnd()).isFalse();
    }

    @DisplayName("Run and Get Nothing")
    @Test
    void run_Nothing() {
        BallGameRunner ballGameRunner = new BallGameRunner(systemBalls, "248");

        assertThat(ballGameRunner.run().getCount(BallStatus.STRIKE)).isEqualTo(0);
        assertThat(ballGameRunner.run().getCount(BallStatus.BALL)).isEqualTo(0);
        assertThat(ballGameRunner.isEnd()).isFalse();
    }


}
