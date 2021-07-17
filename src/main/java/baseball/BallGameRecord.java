package baseball;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

//Record owns Game, not the other way
public class BallRecord {

    private final List<BallStatusRecord> statusMapList;
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
        return statusMapList.stream()
                .findFirst()
                .map(o -> o.countOf(ballStatus))
                .orElse(0);
    }

    //List to ObjList findFirst X just map
    private List<BallStatusRecord> makeStatusMapList() {
        return Arrays.asList(BallStatus.values())
                .stream()
                .map(BallStatusRecord::new)
                .collect(Collectors.toList());
    }

    public List<BallStatusRecord> getStatusMapList() {
        return statusMapList;
    }

}
