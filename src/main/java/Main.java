import java.util.List;

public class Main {

    public static void main(String[] args) {

        while (true) {

            List<String> randomNumber = LottoNumber.makeLottoNumbers();
            System.out.println("정답 : " + randomNumber);
            while (true) {
                final List<String> number = InputView.input();

                if (Answer.correctAnswer(randomNumber, number)) {
                    break;
                }

                final int ball = Ball.getBall(randomNumber, number);
                final int strike = Strike.getStrike(randomNumber, number);

                ResultView.showBallAndStrike(ball,strike);
            }

            if (ResultView.endGame()) {
                break;
            }
        }
    }
}
