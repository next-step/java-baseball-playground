package study.mission01;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public void show() {
        GameBoard gameBoard = new GameBoard();
        // choice: 0=default / 1=reset / 2=end
        int choice = 0;

        while (choice < 2) {

            if (choice == 1) {
                gameBoard.reset();
                choice = 0;
            }

            System.out.print("숫자를 입력해 주세요 : ");
            int input = scanner.nextInt();

            String result = gameBoard.getHint(input);
            System.out.println(result);

            if (gameBoard.isAnswer(input)) {
                System.out.println("3개의 숫자(" + gameBoard.getAnswer() + ")를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                choice = scanner.nextInt();
            }


        }
    }


}
