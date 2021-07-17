package baseball;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

//Record owns Game, not the other way
public class BallRecord {

    private final List<HashMap<BallStatus,Integer>> statusMapList;
    private final BallGame ballGame;

    BallRecord(BallGame ballGame) {
        this.statusMapList = makeStatusMapList();
        this.ballGame = ballGame;
    }

//    //명령 질의 디미터 (실행은 조회값없음)
    public void updateBallRecord(UserBalls userBalls) {
       statusMapList.forEach( o -> updateStatusMap(o, userBalls));
    }

    private void updateStatusMap(HashMap<BallStatus, Integer> map, UserBalls userBalls) {
        if (map.containsKey(BallStatus.STRIKE)) {
            map.put(BallStatus.STRIKE, map.get(BallStatus.STRIKE) + ballGame.countMatchToStrike(userBalls));
        }
        if (map.containsKey(BallStatus.BALL)) {
            map.put(BallStatus.BALL, map.get(BallStatus.BALL) + ballGame.countMatchToBall(userBalls));
        }
        if (map.containsKey(BallStatus.NOTHING)) {
            map.put(BallStatus.NOTHING, map.get(BallStatus.NOTHING) + ballGame.countMatchToNothing(userBalls));
        }
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
        return Objects.equals(getStatusMapList(), that.getStatusMapList()) &&
                Objects.equals(ballGame, that.ballGame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatusMapList(), ballGame);
    }
}
