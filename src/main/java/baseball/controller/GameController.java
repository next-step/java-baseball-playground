package baseball.controller;

import baseball.model.*;
import baseball.model.service.BaseballService;
import baseball.model.view_interface.InputView;
import baseball.model.view_interface.OutputView;

import java.util.List;

public class GameController {

    private String handleInput(OutputView outputView, InputView inputView){
        String input = inputView.getInput();
        try{
            Balls.validateNumbers(input);
        }catch(RuntimeException e){
            outputView.printExceptionMessage(e.getMessage());
            input = handleInput(outputView, inputView);
        }
        return input;
    }


    public void run(OutputView outputView, InputView inputView){
        BaseballService service = new BaseballService();
        Balls answerBalls = new Balls(RandomNumberCreator.makeNumbers());
        boolean runStatus = true;
        while(runStatus){
            String input = handleInput(outputView,inputView);
            List<Integer> judgeResult = service.runBaseballGame(answerBalls, input);
            outputView.printJudgement(service.makeResultMessage(judgeResult));
            runStatus =!Referee.isOut(judgeResult);
        }
        if(restart(outputView, inputView)){
            run(outputView,inputView);
        }
    }

    private boolean restart(OutputView outputView, InputView inputView){
        String decision = inputView.askRestart();
        try {
            BaseballService.validateRestartInput(decision);
        }catch(RuntimeException e){
            outputView.printExceptionMessage(e.getMessage());
            decision = inputView.askRestart();
        }
        if(decision.equals("1")){
            return true;
        }
        return false;

    }

}
