package input;

import java.util.Scanner;

import static input.GAME_PROGRESS_STATUS.getGameProgressByInputCode;

public class InputViewGameProgressService {

    public GAME_PROGRESS_STATUS getGameProgressInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        return getGameProgressByInputCode(userInput);
    }
}
