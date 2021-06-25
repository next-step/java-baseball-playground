package study;

import java.util.List;

public class PlayerService {

    public static final int MAX = 9;
    public static final int MIN = 1;
    private static final int BALLS_SIZE = 3;

    public Player makeNewPlayer() {
        return new Player();
    }

    public boolean validate(List<Integer> ballList) {
        if (!validateBallsSize(ballList))
            return false;

        if (!validateBallsRange(ballList))
            return false;

        if (!validateDuplicate(ballList))
            return false;
        return true;
    }

    private boolean validateDuplicate(List<Integer> ballList) {
        int notDuplicatedSize = (int) ballList.stream()
                .distinct()
                .count();
        return notDuplicatedSize == BALLS_SIZE;
    }

    private boolean validateBallsSize(List<Integer> ballList) {
        return ballList.size() == BALLS_SIZE;
    }

    private boolean validateBallsRange(List<Integer> ballList) {
        int rightRangeSize = (int) ballList.stream()
                .filter(n -> (n <= MAX) && (n >= MIN))
                .count();
        return rightRangeSize == BALLS_SIZE;
    }

}
