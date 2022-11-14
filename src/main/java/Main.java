import java.util.List;
import java.util.Scanner;

public class Main {

    private static LottoNumber lottoNumber = new LottoNumber();
    private static Scanner scanner = new Scanner(System.in);

    private static InputView inputView = new InputView();

    private static Answer answer = new Answer();

    private static ResultView resultView = new ResultView();

    public static void main(String[] args) {

        while (true) {

            List<String> randomNumber = lottoNumber.makeLottoNumbers();

            while (true) {
                final List<String> number = inputView.input();

                if (answer.correctAnswer(randomNumber, number)) {
                    break;
                }

                getBallAndStrike(randomNumber, number);
            }

            if (resultView.endGame()) {
                break;
            }
        }
    }





    private static void getBallAndStrike(final List<String> randomNumber, final List<String> number) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (randomNumber.get(i).equals(number.get(j))) {
                    if (i == j) {
                        strike++;
                        break;
                    }
                    ball++;
                }
            }
        }

        if (ball + strike == 0) {
            System.out.println("Four Ball or Nothing");
            return;
        }

        System.out.println(ball + " 볼 " + strike + "스트라이크");
    }

}
