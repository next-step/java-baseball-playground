package baseball;

import java.util.*;

public class BallStatusRecord {

    private final HashMap<BallStatus, Integer> ballStatusRecord;

    BallStatusRecord(BallStatus ballStatus) {
        this.ballStatusRecord = makeInitRecord(ballStatus);
    }

    public HashMap<BallStatus, Integer> makeInitRecord(BallStatus ballStatus) {
        HashMap<BallStatus, Integer> initMap = new HashMap<>();
        initMap.put(ballStatus, 0);
        return initMap;
    }


    public void updateCountOf(BallStatus ballStatus, int count) {
        if (hasStatus(ballStatus)) {
            ballStatusRecord.put(ballStatus, findCountOf(ballStatus) + count);
        }
    }

    public boolean hasStatus(BallStatus ballStatus) {
        return ballStatusRecord.containsKey(ballStatus);
    }

    public int findCountOf(BallStatus ballStatus) {
            return this.ballStatusRecord.get(ballStatus);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallStatusRecord that = (BallStatusRecord) o;
        return Objects.equals(ballStatusRecord, that.ballStatusRecord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballStatusRecord);
    }
}
