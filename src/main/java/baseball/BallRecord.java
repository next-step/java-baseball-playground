package baseball;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BallRecord {

    private final List<HashMap<BallStatus,Integer>> statusMapList;

    BallRecord() {
        this.statusMapList = makeStatusMapList();
    }


    //Optional Stream 다시 고민
    public int findBallStatusCount(BallStatus ballStatus) {
        int ballStatusCount = 0;
        for (HashMap<BallStatus, Integer> map : this.statusMapList) {
            if (map.containsKey(ballStatus)){
                ballStatusCount = map.get(ballStatus);
            }
        }
        return ballStatusCount;
    }

    //List to ObjList findFirst X just map
    private List<HashMap<BallStatus, Integer>> makeStatusMapList() {
        return Arrays.asList(BallStatus.values())
                .stream()
                .map(o -> makeInitMap(o))
                .collect(Collectors.toList());
    }
    
    private HashMap<BallStatus, Integer> makeInitMap(BallStatus ballStatus) {
        HashMap<BallStatus, Integer> initMap = new HashMap<>();
        initMap.put(ballStatus, 0);
        return initMap;
    }

    public List<HashMap<BallStatus, Integer>> getStatusMapList() {
        return statusMapList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallRecord that = (BallRecord) o;
        return Objects.equals(statusMapList, that.statusMapList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusMapList);
    }
}
