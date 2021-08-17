package view;

import domain.GameStatus;

import java.util.Scanner;

import static java.lang.System.out;

public class GameView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private GameView() {
    }

    public static GameStatus gameInput() {
        out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int status = SCANNER.nextInt();
        return GameStatus.from(status);
    }
}
