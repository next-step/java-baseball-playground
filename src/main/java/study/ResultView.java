package study;

import java.util.Scanner;

public class ResultView {

    public static boolean isNotThreeStrike(BaseBallGameResult result) {
        int strike = result.getStrike();
        int ball = result.getBall();
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }

        if (ball > 0) {
            System.out.printf("%d볼", ball);
        }

        if (strike > 0) {
            System.out.printf("%d스트라이크", strike);
        }
        return true;
    }

    public static boolean isEndGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        while (true) {
            int input = new Scanner(System.in).nextInt();
            if (input == 1) {
                return false;
            } else if (input == 2) {
                return true;
            }
            System.out.println("잘못된 숫자를 입력하셨습니다. 다시 입력해주세요.");
        }
    }
}
