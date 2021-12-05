import java.util.Scanner;

public class Baseball {
    public static void start(){
        Computer com = new Computer();

        while(true){
            Player player = new Player();
            GameConsole gameConsole = new GameConsole(player.getNumber(), com.getNumber());
            gameConsole.play();
            if(gameConsole.isCorrect()) {
                break;
            }
        }

        System.out.print("다시 시작하시려면 1을 종료하려면 2를 눌러주세요 : ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        if(answer.equals("1")){
            Baseball.start();
        }
    }

    public static void main(String[] args) {
        Baseball.start();
    }
}
