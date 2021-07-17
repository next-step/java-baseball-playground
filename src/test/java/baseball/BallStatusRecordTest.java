package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BallStatusRecordTest {

    @DisplayName("make Init Record")
    @Test
    void is_makeInitRecord() {
        BallStatusRecord strikeRecord = new BallStatusRecord(BallStatus.STRIKE);
        BallStatusRecord ballRecord = new BallStatusRecord(BallStatus.BALL);
        BallStatusRecord nothingRecord = new BallStatusRecord(BallStatus.NOTHING);
        assertThat(strikeRecord.findCountOf(BallStatus.STRIKE)).isEqualTo(0);
        assertThat(ballRecord.findCountOf(BallStatus.BALL)).isEqualTo(0);
        assertThat(nothingRecord.findCountOf(BallStatus.NOTHING)).isEqualTo(0);

    }

    @Test
    void is_updateRecord() {
        BallStatusRecord strikeRecord = new BallStatusRecord(BallStatus.STRIKE);
        BallStatusRecord ballRecord = new BallStatusRecord(BallStatus.BALL);
        strikeRecord.updateCountOf(BallStatus.STRIKE, 2);
        strikeRecord.updateCountOf(BallStatus.BALL, 2);
        assertThat(strikeRecord.findCountOf(BallStatus.STRIKE)).isEqualTo(2);
        assertThat(ballRecord.findCountOf(BallStatus.BALL)).isEqualTo(0);

        strikeRecord.updateCountOf(BallStatus.STRIKE, 2);
        assertThat(strikeRecord.findCountOf(BallStatus.STRIKE)).isEqualTo(4);
        assertThat(ballRecord.findCountOf(BallStatus.BALL)).isEqualTo(0);
    }

}