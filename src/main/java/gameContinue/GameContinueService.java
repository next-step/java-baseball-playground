package gameContinue;

import input.GAME_PROGRESS_STATUS;

import java.util.Scanner;

public class GameContinueService {

    public GAME_PROGRESS_STATUS chooseGameContinueOrTerminate() {
        Scanner sc = new Scanner(System.in);

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int userInput = sc.nextInt();
        return GAME_PROGRESS_STATUS.getGameProgressByInputCode(userInput);
    }
}
