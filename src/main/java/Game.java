import java.util.List;
import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);

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
