import java.util.List;
import java.util.Scanner;

public class ResultView {

    public void showBallAndStrike(List<String> randomNumber, List<String> number) {

        final int ball = Ball.getBall(randomNumber, number);
        final int strike = Strike.getStrike(randomNumber, number);

        if (ball + strike == 0) {
            System.out.println("Four ball or Nothing");
            return;
        }

        System.out.println(ball + "볼 " + strike + "스트라이크");

    }
}
