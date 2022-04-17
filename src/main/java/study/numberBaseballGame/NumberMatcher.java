package study.numberBaseballGame;

public class NumberMatcher {
    private static final int TOTAL_COUNT = 3;

    public Score calculateScore(ThreeNumbers trial, ThreeNumbers answer) {
        Score score = new Score();
        int strikeCount = calculateStrike(trial, answer);
        int ballCount = calculateBall(trial, answer);
        int outCount =  TOTAL_COUNT - strikeCount - ballCount;
        score.update(strikeCount, ballCount, outCount);
        return score;
    }

    private int calculateBall(ThreeNumbers trial, ThreeNumbers answer) {
        int ballCount = 0;
        if (trial.getFirst() == answer.getSecond() || trial.getFirst() == answer.getThird()) ballCount++;
        if (trial.getSecond() == answer.getFirst() || trial.getSecond() == answer.getThird()) ballCount++;
        if (trial.getThird() == answer.getFirst() || trial.getThird() == answer.getSecond()) ballCount++;
        return ballCount;
    }

    private int calculateStrike(ThreeNumbers trial, ThreeNumbers answer) {
        int strikeCount = 0;
        if (trial.getFirst() == answer.getFirst()) strikeCount++;
        if (trial.getSecond() == answer.getSecond()) strikeCount++;
        if (trial.getThird() == answer.getThird()) strikeCount++;
        return strikeCount;
    }
}
