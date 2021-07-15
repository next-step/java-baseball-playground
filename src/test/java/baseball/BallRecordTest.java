package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallRecordTest {

    @DisplayName("Empty BallRecord")
    @Test
    void is_EmptyBallRecord(){
        BallRecord ballRecord = new BallRecord();
        assertThat(ballRecord.findBallStatusCount(BallStatus.STRIKE)).isEqualTo(0);
        assertThat(ballRecord.findBallStatusCount(BallStatus.BALL)).isEqualTo(0);
    }

}
