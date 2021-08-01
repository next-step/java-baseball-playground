package BaseBall;

import java.util.ArrayList;

public class Game {
    public static void main(String[] args) {
        Com com=new Com();
        User user=new User();
        Referee referee=new Referee();

        while (true){
           ArrayList<Integer> a= com.ComGenerate();
           ArrayList<Integer> b= user.User();
           int strike= referee.Strike(a,b);
           int ball=referee.Ball(a,b);
           StringBuilder sb=new StringBuilder();
           sb=referee.check(strike,ball);
            System.out.println(sb);
            break;
        }


    }
}
