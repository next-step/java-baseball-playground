package BaseBall;

import java.io.IOException;
import java.util.List;

public class Printer {

    public String print(List<Integer> ar1,List<Integer> ar2)  {
        Referee referee=new Referee();
        int strike=referee.CountStrike(ar1,ar2);
        int ball = referee.CountBall(ar1, ar2);
        String str;
        if(strike==0&&ball==0) {
            str="낫싱";
        }
        else if(strike == 0)
        {
            str = ball+"볼";
        }
        else if(ball == 0){
            str=strike + "스트라이크";
        }
        else str= ball + "볼"+strike + " 스트라이크";
        return str;
    }



}
