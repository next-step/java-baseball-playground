package baseballgame.domain.controller;

import baseballgame.domain.Balls;
import baseballgame.domain.PlayResult;
import baseballgame.domain.util.NumberGenerator;
import baseballgame.domain.view.InputView;
import baseballgame.domain.view.OutPutView;

import java.util.List;

    public class BaseBallGameController {
    NumberGenerator numberGenerator = new NumberGenerator();

    public void play() {
        Balls answer = new Balls(createAnswer());
        PlayResult playResult = answer.play(getUserBalls());
        while (playResult.isGameEnd()){
            OutPutView.printResult(playResult);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");


    }

    private List<Integer> getUserBalls() {
        List<Integer> userBalls;
        try {
            userBalls = InputView.getUserBalls();
        } catch (RuntimeException exception) {
            System.out.println("[ERROR]" + exception.getMessage() + "\n");
            return getUserBalls();
        }
        return userBalls;
    }

    private List<Integer> createAnswer() {
        return numberGenerator.createRandomNumbers();
    }
}
