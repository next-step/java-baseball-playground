import java.util.List;

public class Main {



    public static void main(String[] args) {

        while (true) {

            List<String> randomNumber = LottoNumber.makeLottoNumbers();

            while (true) {
                final List<String> number = InputView.input();

                if (Answer.correctAnswer(randomNumber, number)) {
                    break;
                }

                BallAndStrike.show(randomNumber, number);
            }

            if (ResultView.endGame()) {
                break;
            }
        }
    }
}
