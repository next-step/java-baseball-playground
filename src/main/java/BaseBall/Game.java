package BaseBall;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Com com=new Com();

        Referee referee=new Referee();
        int[] a= com.Com();

        User user=new User();

        while (true){
            int[] b= user.User();
            int strike= referee.Strike(a,b);
           int ball=referee.Ball(a,b);
           StringBuilder sb;
           sb=referee.check(strike,ball);
           if(strike==3){
               System.out.println(sb);
               System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
               break;
           }else{
               System.out.println(sb);
           }

        }


    }
}
