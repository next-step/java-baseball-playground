import java.util.List;
import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);

    private LottoNumber lottoNumber;

    private InputView inputView;

    private Answer answer;

    private ResultView resultView;

    public Game(){
        lottoNumber = new LottoNumber();
        inputView = new InputView();
        answer = new Answer();
        resultView = new ResultView();
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

            if (endGame()) {
                break;
            }
        }
    }

    public boolean endGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

        return scanner.nextInt() == 2;
    }
}
