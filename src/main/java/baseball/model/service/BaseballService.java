package baseball.model.service;


import baseball.model.Balls;
import baseball.model.Referee;

import java.util.List;

public class BaseballService {

    public List<Integer> runBaseballGame(Balls answer, String input) {
        Balls userBalls = new Balls(input);
        List<Integer> judgeResult = Referee.judgement(answer, userBalls);
        return judgeResult;
    }

    public String makeResultMessage(List<Integer> judgeResult) {
        int strike = judgeResult.get(0);
        int ball = judgeResult.get(1);
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
    public static void validateRestartInput(String input) throws RuntimeException {
        if (input.length() != 1 || Integer.parseInt(input) > 2) {
            throw new RuntimeException("1 혹은 2 를 입력해주세요");
        }
    }

}
