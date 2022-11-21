package numberBaseballGame;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> computerNumber;
        List<Integer> userNumber;
        UserNumberVerified verified;
        GenerateRandomNumber randomNumber = new GenerateRandomNumber();
        Referee referee;
        GameController gameController;

        while(true) {
            computerNumber = randomNumber.getComputerNumber();
            System.out.println("computer : " + computerNumber);

            System.out.println("숫자를 입력해 주세요 : ");
            String input = sc.next();

            verified = new UserNumberVerified(input);
            userNumber = verified.getUserNumberList();

            referee = new Referee(computerNumber, userNumber);
            System.out.println(referee.makeHint());

            gameController = new GameController(referee);

            if (reGame(sc, gameController)) break;
        }
    }

    private static boolean reGame(Scanner sc, GameController gameController) {
        if(!gameController.continueGame()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 누르세요.");

            int selectGame = sc.nextInt();

            if(selectGame == 1) {
                initGame();
            }

            else if(selectGame == 2)
                return true;
        }
        return false;
    }

    private static void initGame() {

    }
}