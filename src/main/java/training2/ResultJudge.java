package training2;

import java.util.List;

public class ResultJudge {

    public boolean resultJudge(List<Integer> computer, List<Integer> player) {
        NumCompare numCompare = new NumCompare();
        StringBuilder sb = new StringBuilder();

        if (numCompare.countStrike(computer, player) == 3) {
            //정답
            return true;
        }

        if (numCompare.countStrike(computer, player) != 3) {
            int strike = numCompare.countStrike(computer, player);
            int ball = numCompare.countBall(computer, player);

            if (strike == 0 && ball == 0) {
                sb.append("포볼");
            }

            if (strike > 0) {
                sb.append(strike + "스트라이크 ");
            }

            if (ball > 0) {
                sb.append(ball + "볼 ");
            }

            System.out.println(sb.toString());

            return false;
        }

        return false;
    }

}
