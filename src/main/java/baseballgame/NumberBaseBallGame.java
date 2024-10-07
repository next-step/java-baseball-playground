package baseballgame;

import util.BaseballRandomNumber;
import util.BaseballScanner;
import util.RandomNumberUtil;
import util.ScannerUtil;

public class NumberBaseBallGame {

    private final InputView inputView;
    private String[] randomNumber;

    public NumberBaseBallGame() {
        RandomNumberUtil randomNumberCreator = new BaseballRandomNumber();
        ScannerUtil scanner = new BaseballScanner();
        this.inputView = new InputView(scanner);
        randomNumber = randomNumberCreator.createRandomNumber();
    }

    public void start() {
        boolean isCorrect = false;

        while (!isCorrect) {
            final String[] input = inputView.input();
            int strikes = 0, balls = 0;

            // 스트라이크 체크
            strikes = checkStrikes(input, strikes);

            // 볼 체크
            balls = checkBalls(input, balls);

            if (printBallStrikeCount(strikes, balls)) break;
        }
    }

    private boolean printBallStrikeCount(final int strikes, final int balls) {
        if (strikes == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            final String s = inputView.getScanner().nextLine();

            if (resetOrRestart(s)) return true;
        }

        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        }

        if (strikes > 0 && balls == 0) {
            System.out.println(strikes + "스트라이크");
        }

        if(strikes == 0 && balls > 0) {
            System.out.println(balls + "볼");
        }

        if (strikes > 0 && balls > 0) {
            System.out.println(strikes + "스트라이크 " + balls + " 볼");
        }
        return false;
    }

    private boolean resetOrRestart(final String s) {
        if (s.equals("1")) {
            start();
        }

        if (s.equals("2")) {
            return true;
        }
        return false;
    }

    private int checkBalls(final String[] input, int balls) {
        for (int i = 0; i < 3; i++) {
            if (!randomNumber[i].equals(input[i]) && containsNumbers(randomNumber, input[i])) {
                balls++;
            }
        }
        return balls;
    }

    private int checkStrikes(final String[] input, int strikes) {
        for (int i = 0; i < 3; i++) {
            if (randomNumber[i].equals(input[i])) {
                strikes++;
            }
        }
        return strikes;
    }

    private boolean containsNumbers(final String[] randomNumber, final String s) {
        for (String e : randomNumber) {
            if (e.equals(s)) {
                return true;
            }
        }
        return false;
    }
}
