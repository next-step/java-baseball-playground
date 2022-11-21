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

        for(Integer i : computerNumberList) {
            if(computerNumberList.indexOf(i) == userNumberList.indexOf(i)) {
                strike += 1;
            }
        }
        return strike;
    }

    public int ballCount() {
        int ball = 0;

        for(Integer i : computerNumberList) {
            if(userNumberList.contains(i)) {
                ball += 1;
            }
        }
        return ball;
    }
}
