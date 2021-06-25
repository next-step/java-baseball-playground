package study;

import java.util.ArrayList;
import java.util.List;

public class Player {

    List<Integer> ballList = new ArrayList<>();

    public List<Integer> makeNewBalls(List<Integer> newIntegerList) {
        ballList.addAll(newIntegerList);
        return this.ballList;
    }

    public Status play(int userBallIndex, int userBallNum) {
        if (isStrike(userBallIndex, userBallNum))
            return Status.STRIKE;

        if (isBall(userBallNum))
            return Status.BALL;

        return Status.NOTHING;
    }

    private boolean isBall(int userBallNum) {
        return ballList.contains(userBallNum);
    }

    private boolean isStrike(int userBallIndex, int userBallNum) {
        return ballList.get(userBallIndex) == userBallNum;
    }
}
