package baseball.domain;

import java.util.ArrayList;

public class Judgement {
    public int findSameNumbers(ArrayList<Integer> computer,ArrayList<Integer> player) {
        int sameCnt = 0;
        for (int i = 0; i < player.size(); i++) {
            if (computer.contains(player.get(i))) {
                sameCnt++;
            }
        }
        return sameCnt;
    }

    public int getStrikeCnt(ArrayList<Integer> computer, ArrayList<Integer> player) {
        int strikeCnt = 0;
        for (int i = 0; i < player.size(); i++) {
            if (computer.get(i).equals(player.get(i))) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }
}
