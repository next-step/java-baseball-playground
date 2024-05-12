package baseball.core;

import baseball.view.InputView;
import baseball.view.ResultView;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BaseballGame {
    private final String correctAnswer;
    private final InputView inputView;
    private final ResultView resultView;

    public BaseballGame(final String correctAnswer) {
        this.correctAnswer = correctAnswer;
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    /**
     * 게임 프로그램을 실행한다.
     */
    public static void run() {
        GameStatus gameStatus = GameStatus.CONTINUE;
        while (GameStatus.CONTINUE.equals(gameStatus)) {
            final String correctAnswer = BaseballGame.generateRandomNumbers();
            final BaseballGame baseballGame = new BaseballGame(correctAnswer);
            baseballGame.startNewGame();
            gameStatus = baseballGame.askForNewGameOrExit();
        }
    }

    /**
     * 1에서 9까지 서로 다른 임의의 수 3개를 생성한다.
     */
    public static String generateRandomNumbers() {
        final Set<Integer> alreadySelectedNumbers = new HashSet<>();
        while (alreadySelectedNumbers.size() < 3) {
            int randomNumber = new Random().nextInt(9) + 1;
            alreadySelectedNumbers.add(randomNumber);
        }

        final StringBuilder builder = new StringBuilder();
        alreadySelectedNumbers.forEach(builder::append);

        return builder.toString();
    }

    /**
     * 새 게임을 시작한다.
     */
    public void startNewGame() {
        AnswerStatus answerStatus = AnswerStatus.WRONG;
        while (AnswerStatus.WRONG.equals(answerStatus)) {
            String userInput = inputView.getUserInput();
            GameResult gameResult = GameResult.of(correctAnswer, userInput);
            resultView.output(gameResult);
            answerStatus = gameResult.getAnswerStatus();
        }
    }

    /**
     * 유저에게 새 게임 시작 여부를 받는다.
     */
    public GameStatus askForNewGameOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (new Scanner(System.in).nextInt() == 1) {
            return GameStatus.CONTINUE;
        }
        return GameStatus.END;
    }
}
