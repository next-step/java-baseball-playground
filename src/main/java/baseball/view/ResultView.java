package baseball.view;

import baseball.domain.GameResult;

public class ResultView {

    private ResultView() {
    }

    public static String result(GameResult result) {
        String resultMessage = "";

        if (result.getBall() != 0) {
            resultMessage = result.getBall() + "볼";
        }

        if (result.getStrike() != 0) {
            resultMessage += " " + result.getStrike() + "스트라이크";
        }

        return resultMessage;
    }

    public static String endMessage() {
        return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }

    public static String restartMessage() {
        return "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    }
}
