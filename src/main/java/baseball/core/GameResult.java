package baseball.core;

public class GameResult {
    private final int strikeCount;
    private final int ballCount;

    public GameResult(final int strikeCount, final int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static GameResult of(final String correctAnswer, final String userInput) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < userInput.length(); i++) {
            strikeCount += isStrike(correctAnswer.charAt(i), userInput.charAt(i));
        }

        for (int i = 0; i < userInput.length(); i++) {
            ballCount += isBall(correctAnswer, userInput.charAt(i));
        }

        return new GameResult(strikeCount, ballCount - strikeCount);
    }


    private static int isStrike(char correctAnswer, char userInput) {
        if (correctAnswer == userInput) {
            return 1;
        }
        return 0;
    }

    private static int isBall(String correctAnswer, char userInput) {
        if (correctAnswer.contains(userInput + "")) {
            return 1;
        }
        return 0;
    }


    public String getGameResult() {
        if (strikeCount == 3) {
            return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        if (isNoting()) {
            return "낫싱";
        }

        StringBuilder builder = new StringBuilder();
        if (ballCount > 0) {
            builder.append(ballCount);
            builder.append("볼 ");
        }
        if (strikeCount > 0) {
            builder.append(strikeCount);
            builder.append("스트라이크");
        }
        return builder.toString();
    }

    public AnswerStatus getAnswerStatus() {
        if (isCorrect()) {
            return AnswerStatus.CORRECT;
        }
        return AnswerStatus.WRONG;
    }

    private boolean isNoting() {
        return strikeCount + ballCount == 0;
    }

    private boolean isCorrect() {
        return strikeCount == 3;
    }
}
