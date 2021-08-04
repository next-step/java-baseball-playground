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
        while (true){
            List<Integer> user=input.input();
            String str=printer.print(com, user);
            if(str.equals("3스트라이크")) {
               newCame.choice();
            }else {
                System.out.println(str);
            }

        }
    }

}
