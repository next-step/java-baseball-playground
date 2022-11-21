package numberBaseballGame;

import java.util.List;

public class Referee {
    private List<Integer> computerNumberList;
    private List<Integer> userNumberList;

    public Referee(List<Integer> computerNumber, List<Integer> userNumber) {
        this.computerNumberList = computerNumber;
        this.userNumberList = userNumber;
    }

    public int strikeCount() {
        int strike = 0;

        for (Integer i : computerNumberList) {
            if (computerNumberList.indexOf(i) == userNumberList.indexOf(i)) {
                strike += 1;
            }
        }
        return strike;
    }

    public int ballCount() {
        int ball = 0;

        for (Integer i : computerNumberList) {
            if (userNumberList.contains(i) && isSameDigit(i)) {
                ball += 1;
            }
        }
        return ball;
    }

    private boolean isSameDigit(Integer i) {
        return userNumberList.indexOf(i) != computerNumberList.indexOf(i);
    }


    public String makeHint() {
        String resultHint = "";

        int strike = strikeCount();
        int ball = ballCount();

        if (strike != 0 && ball != 0) {
            return resultHint = ball + "볼 " + strike + "스트라이크";
        }

        if (strikeCount() != 0) {
            return resultHint = strike + "스트라이크";
        }

        if (ballCount() != 0) {
            return resultHint = ball + "볼";
        }

        return "낫싱";
    }
}
