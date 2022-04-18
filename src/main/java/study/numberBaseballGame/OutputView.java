package study.numberBaseballGame;

public class OutputView {

    public static void gameContinueMessage() {
        System.out.println(ViewString.GAME_CONTINUE.description);
    }

    public static void BallMessage(int ballCount) {
        System.out.printf(ViewString.BALL.description, ballCount);
    }

    public static void StrikeMessage(int strikeCount) {
        System.out.printf(ViewString.STRIKE.description, strikeCount);
    }

    public static void WinGame() {
        System.out.println(ViewString.WIN_GAME.description);
    }

    public static void InputNumberMessage() {
        System.out.println(ViewString.INPUT_NUMBER.description);
    }

    public static void InvalidInputWarningMessage() {
        System.out.println(ViewString.INVALID_INPUT_WARNING);
    }

    private enum ViewString {
        GAME_CONTINUE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
        BALL("%d볼"),
        STRIKE(" %d스트라이크"),
        WIN_GAME("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
        INPUT_NUMBER("\n숫자를 입력해주세요 : "),
        INVALID_INPUT_WARNING("\n입력이 잘못되었습니다. 입력이 한 번 더 잘못되면 프로그램이 종료됩니다.");

        private final String description;

        ViewString(String description) {
            this.description = description;
        }
    }
}
