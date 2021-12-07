package baseball.domain;

import java.util.ArrayList;

public class Referee {
    public String compare(ArrayList<Integer> computer, ArrayList<Integer> player) {
        Judgement judgement = new Judgement();
        int findSameNumbers = judgement.findSameNumbers(computer, player);
        int strikeCnt = judgement.getStrikeCnt(computer, player);
        int ballCnt = findSameNumbers - strikeCnt;

        if (strikeCnt == 3) {
            return "3스트라이크";
        }
        if (strikeCnt == 0 && ballCnt == 0) {
            return "낫싱";
        }
        if (strikeCnt != 0 && ballCnt == 0) {
            return strikeCnt + "스트라이크";
        }
        if (strikeCnt == 0) {
            return ballCnt + "볼";
        }
        return ballCnt + "볼 " + strikeCnt + "스트라이크";
    }
}
