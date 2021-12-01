import java.util.Scanner;

public class Baseball {
    public static void main(String[] args) {
        Computer com = new Computer();

        while(true){
            Player player = new Player();
            GameConsole gameConsole = new GameConsole(player.getNumber(), com.getNumber());
            gameConsole.play();
            if(gameConsole.isCorrect()) {
                break;
            }
        }
    }
}
