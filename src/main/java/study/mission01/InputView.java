package study.mission01;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;
    private int input = 0;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public void show() {
        GameBoard gameBoard = new GameBoard();
        System.out.println("gameBoard.getAnswer() = " + gameBoard.getAnswer());
        int start = 1;

        while (start != 2) {
            System.out.print("숫자를 입력해 주세요 : ");
            input = scanner.nextInt();

            String hint = gameBoard.getHint(input);
            System.out.println(hint);

            // input 이 정답인 경우
            if (input == gameBoard.getAnswer()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                start = scanner.nextInt();
            }

        }
    }


}
