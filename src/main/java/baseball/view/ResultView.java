package baseball.view;

import baseball.domain.GameResult;

public class ResultView {

    private ResultView() {
    }

    public static String result(GameResult result) {
        if (result.getStrike() == 0 && result.getBall() == 0) {
            return "낫씽";
        }

        if (result.getBall() == 0) {
            return result.strikeMessage();
        }

        if (result.getStrike() == 0) {
            return result.ballMessage();
        }

        return result.ballMessage() + " " + result.strikeMessage();
    }

    public static String endMessage() {
        return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }

    public static String restartMessage() {
        return "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    }
}
