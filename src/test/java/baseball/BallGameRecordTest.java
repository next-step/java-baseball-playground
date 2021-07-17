package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallRecordTest {

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

    @DisplayName("Empty BallRecord")
    @Test
    void is_Empty_BallRecord(){
        BallRecord ballRecord = new BallRecord(ballGame);
        assertThat(ballRecord.findBallStatusCount(BallStatus.STRIKE)).isEqualTo(0);
        assertThat(ballRecord.findBallStatusCount(BallStatus.BALL)).isEqualTo(0);
    }

}
