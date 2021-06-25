package study;

import java.util.List;

public class PlayerService {

    private static int BALLS_SIZE = 3;

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
        return (int) ballList.stream().distinct().count() == 3;
    }

    private boolean validateBallsSize(List<Integer> ballList) {
        return ballList.size() == BALLS_SIZE;
    }

    private boolean validateBallsRange(List<Integer> ballList) {
        return (int) ballList.stream().filter(n -> (n <= 9) && (n >= 1)).count() == 3;
    }

}
