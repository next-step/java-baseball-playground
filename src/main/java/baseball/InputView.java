package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final int RESTART = 1;
    private static final int GAME_END = 2;

    private static Scanner scanner = new Scanner(System.in);

    public static List<Integer> userInput() {
        List<Integer> result = new ArrayList<>();
        System.out.print("숫자를 입력해 주세요 : ");
        String num = scanner.nextLine();
        String[] split = num.split("");
        for (int i = 0; i < split.length; i++) {
            result.add(Integer.parseInt(split[i]));
        }

        return result;
    }

    public boolean isGameEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int command = Integer.parseInt(scanner.nextLine());
        if (command == RESTART) {
            return false;
        }

        return true;
    }
}
