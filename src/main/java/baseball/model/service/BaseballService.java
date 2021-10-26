package baseball.model.service;

import baseball.model.Balls;
import baseball.model.Judgement;
import baseball.model.Referee;
import baseball.model.exceptions.BallsFormatException;
import baseball.model.exceptions.InputFormatException;

public class BaseballService {

    public Judgement runBaseballGame(Balls answer, String input) throws BallsFormatException, InputFormatException {
        Balls.validateNumbers(input);
        Balls userBalls = new Balls(input);
        return Referee.judgement(answer, userBalls);
    }

    public String makeResultMessage(Judgement judgeResult) {
        int strike = judgeResult.getStrike();
        int ball = judgeResult.getBall();

        if (strike != 0 && ball != 0) {
            return strike + "스트라이크 " + ball + "볼";
        }
        if (strike == 0 && ball != 0) {
            return ball + "볼";
        }
        if (strike != 0 && ball == 0) {
            return strike + "스트라이크";
        }
        if (strike == 3) {
            return "정답을 맞히셨습니다! 게임 종료.";
        }
        return "낫싱";
    }
}
