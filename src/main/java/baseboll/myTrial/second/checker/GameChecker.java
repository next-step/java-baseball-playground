package baseboll.myTrial.second.checker;

public class GameChecker {
    private NothingChecker nothingChecker;
    private CorrectChecker correctChecker;
    private StrikeChecker strikeChecker;
    private BallChecker ballChecker;

    public GameChecker() {
        init();
    }

    private void init() {
        this.ballChecker = new BallChecker();
        this.correctChecker = new CorrectChecker();
        this.nothingChecker = new NothingChecker();
        this.strikeChecker = new StrikeChecker();
    }

    public String check(String input, String answer){
        if (this.correctChecker.isCorrect(input, answer)) return "정답";
        int strikeCount = strikeChecker.countStrike(input, answer);
        int ballCount = ballChecker.countBall(input, answer, strikeCount);
        if (nothingChecker.isNothing(strikeCount, ballCount)) return "낫싱";
        String ball = ballCount + "볼";
        if (strikeCount == 0 && ballCount != 0) return ball;
        String strike = strikeCount + "스트라이크";
        if (ballCount == 0 && strikeCount != 0) return strike;
        return strike + ball;
    }
}