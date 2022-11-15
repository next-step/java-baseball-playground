import java.util.List;

public class Game {

    public Game() {}

    public void start(){
        while (true) {

            List<String> randomNumber = LottoNumber.makeLottoNumbers();

            while (true) {
                final List<String> number = InputView.input();

                if (Answer.correctAnswer(randomNumber, number)) {
                    break;
                }

                ResultView.showBallAndStrike(randomNumber, number);
            }

            if (ResultView.endGame()) {
                break;
            }
        }
    }
}
