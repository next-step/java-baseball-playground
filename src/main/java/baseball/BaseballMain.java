package baseball;

import java.util.List;
import java.util.Scanner;

public class BaseballMain {

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        List<Integer> me = BaseballView.askGameInput();
            while (baseballGame.isStrike(me) != 3) {
                BaseballView.showGameResult(baseballGame, me);
                me = BaseballView.askGameInput();

                if (baseballGame.isStrike(me) == 3) {
                    BaseballView.showGameResult(baseballGame, me);
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    Scanner scanner = new Scanner(System.in);
                    String closeInput = scanner.nextLine();
                    if (closeInput.equals("1")) {
                        //reStart main function!
                        BaseballMain.main(args);
                    }
                    if (closeInput.equals("2")) {
                    } else {
                        throw new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    }
                }
            }

        }
    }
