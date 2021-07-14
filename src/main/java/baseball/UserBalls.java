package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserBalls {

    private final List<Ball> userBallList;

    public UserBalls(String input) {
        this.userBallList = makeUserBalls(input);
    }

    public static List<Ball> makeUserBalls(String input) throws IllegalArgumentException {
        String[] inputs = input.split("");
        if (input.length() != 3) {
            throw new IllegalArgumentException("Not 3 numbers");
        }
        //check BallNum
        List<BallNum> ballNumList = Arrays.stream(inputs)
                                        .map(BallNum::new)
                                        .collect(Collectors.toList());

        if (ballNumList.stream().distinct().count() != 3) {
            throw new IllegalArgumentException("Not Distinct 3 numbers");
        }
        List<Ball> ballList = new ArrayList<>();
        for (int i = 0 ; i < 3 ; i++) {
            ballList.add(i, new Ball(ballNumList.get(i), i+1));
        }
        return ballList;
    }

    public List<Ball> getUserBallList() {
        return userBallList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBalls userBalls = (UserBalls) o;
        return Objects.equals(userBallList, userBalls.userBallList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userBallList);
    }
}
