package baseballgame;

import java.util.ArrayList;

public class Refree {
    public int strike = 0;
    public int ball = 0;

    Judgement judgement = new Judgement();

    public void makeCall(ArrayList computer, ArrayList user) {
        strike = 0;
        ball = 0;
        int count = judgement.isContainNumber(computer, user);
        for (int index = 0; index < user.size(); index++) {
            int userNum = (int) user.get(index);
            if (judgement.isCheckNumber(computer, index, userNum)) {
                strike++;
            }
        }
        ball = count - strike;
    }
}
