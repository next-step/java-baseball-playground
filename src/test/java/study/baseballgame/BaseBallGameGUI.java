package study.baseballgame;

import java.io.IOException;
import java.util.Scanner;


public class BaseBallGameGUI {

    public static void main(String[] args) throws IOException {
        BaseballGame bs = BaseballGame.start();


        Scanner scanner = new Scanner(System.in);
        while(true){
            int s = 0;
            String num = "";
            try{
               // System.out.println(NamingTest.ONETONINE.getName());
                num = scanner.nextLine();
                bs.valid(num);

                s = bs.checkStrikeAndBall(num);

            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

            if(s == 3){
                System.out.println("재시작 하시려면 1, 종료하시려면 0을 눌러주세요");
                num = scanner.nextLine();
            }

            if(num.equals("1")){
                bs = BaseballGame.start();
            }

            if(num.equals("0")){
                System.out.println("종료합니다.");
                break;
            }
        }
    }
}
