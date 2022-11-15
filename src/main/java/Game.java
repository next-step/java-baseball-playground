import java.util.List;
import java.util.Scanner;

public class Game {

    private Scanner scanner;

    private LottoNumber lottoNumber;

    private InputView inputView;

    private Answer answer;

    private ResultView resultView;

    public Game(){
        lottoNumber = new LottoNumber();
        inputView = new InputView();
        answer = new Answer();
        resultView = new ResultView();
        scanner = new Scanner(System.in);
    }

    public void start(){
        while (true) {

            List<String> randomNumber = lottoNumber.makeLottoNumbers();

            while (true) {
                final List<String> number = inputView.input();

                if (answer.correctAnswer(randomNumber, number)) {
                    break;
                }

                resultView.showBallAndStrike(randomNumber, number);
            }

            if (end()) {
                break;
            }
        }
    }

    private boolean end() {
        resultView.choose();

        return scanner.nextInt() == 2;
    }
}
