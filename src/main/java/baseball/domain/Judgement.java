package baseball.domain;

import java.util.List;

public class Judgement {
    public int findSameNumbers(List<Integer> computer, List<Integer> player) {
        int sameCnt = 0;
        for (int i = 0; i < player.size(); i++) {
            if (computer.contains(player.get(i))) {
                sameCnt++;
            }
        }
        return sameCnt;
    }

    public int getStrikeCnt(List<Integer> computer, List<Integer> player) {
        int strikeCnt = 0;
        for (int i = 0; i < player.size(); i++) {
            if (computer.get(i).equals(player.get(i))) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }
}
