package BaseBall;

import java.util.List;

public class Referee {

    public int CountStrike(List<Integer> ar1,List<Integer> ar2){
        int strike=0;
        for (int i = 0; i < 3; i++) {
            if (ar1.get(i)==ar2.get(i)) strike++;
        }
        return strike;
    }

    public int CountBall(List<Integer> ar1,List<Integer> ar2){
        int ball=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(ar1.get(i)==ar2.get(j)&&i!=j) ball++;
            }
        }
        return ball;
    }

}
