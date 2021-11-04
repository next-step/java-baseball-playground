package baseball.controller;

import baseball.model.*;
import baseball.model.exceptions.BallsFormatException;
import baseball.model.exceptions.InputFormatException;
import baseball.model.service.BaseballService;
import baseball.model.view_interface.InputView;
import baseball.model.view_interface.OutputView;


public class GameController {
    private OutputView outputView;
    private InputView inputView;


    public GameController(OutputView o, InputView i) {
        outputView = o;
        inputView = i;
    }

    public void run() {
        BaseballService service = new BaseballService();
        Balls answerBalls = new Balls(RandomNumberCreator.makeNumbers());
        boolean runStatus = true;

        while (runStatus) {
            String input = inputView.getInput();
            try {
                Judgement judgeResult = service.runBaseballGame(answerBalls, input);
                outputView.printJudgement(service.makeResultMessage(judgeResult));
                runStatus = !Referee.isOut(judgeResult);
            } catch (InputFormatException ex) {
                outputView.printExceptionMessage(ex.getMessage());
            }catch(BallsFormatException e){
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }
}
