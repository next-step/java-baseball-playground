package baseball;

public class ResultView {
    public void printGameResult(int ball, int strike) {
        System.out.println(makeGameResultMessage(ball, strike));
    }

    public String makeGameResultMessage(int ball, int strike) {
        String message = "낫싱";

        if (ball > 0) {
            message = String.format("%d볼", ball);
        }
        if (strike > 0) {
            message = String.format("%d스트라이크", strike);
        }
        if (ball > 0 && strike > 0) {
            message = String.format("%d볼 %d스트라이크", ball, strike);
        }

        return message;
    }

    public void printStageDoneMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printGameCloseMessage() {
        System.out.println("모든 게임을 종료합니다.");
    }
}
