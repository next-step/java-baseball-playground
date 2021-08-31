package view;

import domain.GameStatus;

import java.util.Scanner;

public class GameConsoleView implements GameView {

    private final Scanner scanner;

    private GameConsoleView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public static GameConsoleView from(final Scanner scanner) {
        return new GameConsoleView(scanner);
    }

    public GameStatus gameInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String status = scanner.nextLine();
        return GameStatus.from(status);
    }
}
