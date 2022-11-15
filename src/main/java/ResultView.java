import java.util.List;

public class ResultView {

    private Ball ball;
    private Strike strike;

    public ResultView() {
        this.ball = new Ball();
        this.strike = new Strike();
    }

    public void showBallAndStrike(List<String> randomNumber, List<String> number) {

        final int ballCount = ball.getBall(randomNumber, number);
        final int strikeCount = strike.getStrike(randomNumber, number);

        if (ballCount + strikeCount == 0) {
            System.out.println("Four ball or Nothing");
            return;
        }

        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");

    }
}
