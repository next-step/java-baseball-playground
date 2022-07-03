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
}
