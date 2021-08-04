package BaseBall;

import java.io.IOException;
import java.util.Scanner;

public class NewGame {

    public void choice() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice = sc.nextInt();
        if(choice==1){
            BaseBall baseBall=new BaseBall();
            baseBall.Game();
        }

    }
}
