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
        PlayResult playResult = new PlayResult();

        while(!playResult.isGameEnd()){
            playResult = answer.play(getUserBalls());
            OutPutView.printResult(playResult);
        }
        OutPutView.printGameEnd();
        try {
            if(InputView.retryGame()==1){
                play();
            }
        } catch (RuntimeException e){
            System.out.println("[ERROR]" + e.getMessage() + "\n");
            InputView.retryGame();
        }

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
