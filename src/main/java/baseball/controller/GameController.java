package baseball.controller;

import baseball.model.Balls;
import baseball.model.RandomNumberCreator;
import baseball.model.Referee;
import baseball.model.User;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    private Balls makeUserBall(){
        User user = new User();
        Balls userBalls;
        String input = InputView.getInput();
        try {
            user.validateBallInput(input);
            userBalls = new Balls(input);
        }catch(RuntimeException e){
            OutputView.printExceptionMessage(e.getMessage());
            userBalls = makeUserBall();
        }
        return userBalls;
    }

    public void run(){
        Balls answerBalls = new Balls(RandomNumberCreator.makeNumbers());
        boolean runStatus = true;
        while(runStatus){
            Balls userBalls = makeUserBall();
            List<Integer> judgeResult = Referee.judgement(answerBalls, userBalls);
            OutputView.printJudgement(judgeResult);
            runStatus = !Referee.isOut(judgeResult);
        }
        if(restart()){
            run();
        }

    }
    private boolean restart(){
        User user = new User();
        String decision = InputView.askRestart();
        try {
            user.validateRestartInput(decision);
        }catch(RuntimeException e){
            OutputView.printExceptionMessage(e.getMessage());
            decision = InputView.askRestart();
        }
        if(decision.equals("1")){
            return true;
        }
        return false;

    }

}
