package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {

    List<Integer> ballList = new ArrayList<>();

    public void makeComputersRandomBalls() {
        ballList = new ArrayList<>();
        while (ballList.size() != 3) {
            int value = (int) (Math.random() * 9) + 1;
            addValueInList(value);
        }
    }

    public void addValueInList(int value) {
        if (!ballList.contains(value))
            ballList.add(value);
    }

    public List<Integer> makeNewBalls(List<Integer> newIntegerList) {
        ballList.addAll(newIntegerList);
        return this.ballList;
    }

    public boolean isThreeStrike(List<Integer> userBallsList) {
        List<Status> statusList = play(userBallsList);
        int strikeCount = (int) statusList.stream()
                .filter(status -> status == Status.STRIKE)
                .count();
        if (strikeCount == 3)
            return true;
        return false;
    }

    public boolean isThreeStrike(String userBallsList) {
        List<Status> statusList = play(userBallsList);
        int strikeCount = (int) statusList.stream()
                .filter(status -> status == Status.STRIKE)
                .count();
        if (strikeCount == 3)
            return true;
        return false;
    }

    public List<Status> play(String userBallsString) {
        Status firstStatus = play(0, userBallsString.charAt(0) - '0');
        Status secondStatus = play(1, userBallsString.charAt(1) - '0');
        Status thirdStatus = play(2, userBallsString.charAt(2) - '0');
        return Arrays.asList(firstStatus, secondStatus, thirdStatus);
    }

    public List<Status> play(List<Integer> userBallsList) {
        Status firstStatus = play(0, userBallsList.get(0));
        Status secondStatus = play(1, userBallsList.get(1));
        Status thirdStatus = play(2, userBallsList.get(2));
        return Arrays.asList(firstStatus, secondStatus, thirdStatus);
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
