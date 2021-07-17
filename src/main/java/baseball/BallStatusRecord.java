package baseball;

import java.util.HashMap;

public class BallStatusMap {

    private final HashMap<BallStatus, Integer> ballStatusMap;

    BallStatusMap(BallStatus ballStatus) {
        this.ballStatusMap = makeInitMap(ballStatus);
    }

    public HashMap<BallStatus, Integer> makeInitMap(BallStatus ballStatus) {
        HashMap<BallStatus, Integer> initMap = new HashMap<>();
        initMap.put(ballStatus, 0);
        return initMap;
    }

    public int countOf(BallStatus ballStatus) {
        if (this.ballStatusMap.containsKey(ballStatus)) {
            return this.ballStatusMap.get(ballStatus);
        }
        return 0;
    }



}
