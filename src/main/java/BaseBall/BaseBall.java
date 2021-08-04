package BaseBall;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class BaseBall {

    public void Game() throws IOException {
        Scanner sc = new Scanner(System.in);
        Referee referee=new Referee();
        NumGenrater numGenrater=new NumGenrater();
        Printer printer=new Printer();
        Input input=new Input();
        NewGame newCame = new NewGame();
        List<Integer> com=numGenrater.numGenerater();
        BaseBall baseBall=new BaseBall();
        while (true){
            List<Integer> user=input.input();
            String str=printer.print(com, user);
            if(str.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                if(newCame.choice()) baseBall.Game();
                else break;
            }else {
                System.out.println(str);
            }

        }
    }

}
