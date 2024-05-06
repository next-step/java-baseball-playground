package baseballgame;

import java.util.List;
public class Application {
    public void res_equals(String result, List<Integer> com_num){
        Compare compare = new Compare();
        playgame game = new playgame();
        while(!result.equals("3strike")) {
            result = compare.Compare_num(com_num, game.player_num());
            System.out.println(result);
        }
    }
    public static void main(String[] args) throws IllegalArgumentException{
        try{
            ComputerNum computer = new ComputerNum();
            playgame game = new playgame();
            Compare compare = new Compare();
            Regame regame = new Regame();
            Application app = new Application();

            boolean again = true;

            while(again) {
                List<Integer> com_num = computer.ComputerNumber();
                List<Integer> player_num = game.player_num();

                String result = "";
                app.res_equals(result,com_num);

                again = regame.restart();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

    }
}
