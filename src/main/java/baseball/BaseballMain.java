package baseball;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BaseballMain {

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        List<Integer> me = BaseballView.askGameInput();
        if (baseballGame.isStrike(me) == 3) {
            BaseballView.showGameResult(baseballGame, me);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Scanner scanner = new Scanner(System.in);
            String closeInput = scanner.nextLine();
            if (closeInput.equals("1")) {
                BaseballGame baseballGame1 = new BaseballGame();
            }
        }
        while (baseballGame.isStrike(me) != 3) {
            BaseballView.showGameResult(baseballGame, me);
            me = BaseballView.askGameInput();
//            BaseballView.showGameResult(baseballGame, me);
        }
    }
}