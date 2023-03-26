package baesballgame.model.computer.controller;

import baesballgame.model.computer.dto.ResponseResult;
import baesballgame.model.computer.service.CheckService;
import baesballgame.view.InputView;
import baesballgame.view.OutputView;

public class ViewController {

    private final CheckService checkService;
    private final InputView inputView;
    private final OutputView outputView;

    public ViewController() {
        this.checkService = new CheckService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void play() {
        checkService.createRandomNumber();

        while (true) {
            int requestNumber = inputView.input();
            ResponseResult responseResult = checkService.play(requestNumber);
            outputView.output(responseResult);

            int option = 0;
            if (responseResult.getStrike() == 3) {
                option = inputView.restartOrEnd();
            }

            if (option == 1) {
                checkService.createRandomNumber();
            }

            if (option == 2) break;
        }
    }
}
