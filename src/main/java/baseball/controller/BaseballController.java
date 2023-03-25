package baseball.controller;

import baseball.model.dto.BaseballGameResultDto;
import baseball.model.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    private final InputView inputView;

    private final OutputView outputView;

    private final BaseballService baseballService;

    public BaseballController(InputView inputView, OutputView outputView, BaseballService baseballService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseballService = baseballService;
    }

    public void start() {
        try {
            String numbers = inputView.number();
            baseballService.validateInputValue(numbers);
            BaseballGameResultDto gameResult = baseballService.getGameResult(numbers);
            outputView.result(gameResult);
            end(gameResult.getComplete());
        } catch (IllegalArgumentException e) {
            outputView.exception(e.getMessage());
            start();
        }
    }

    private void end(Boolean complete) {
        if (complete) {
            retry();
        }

        if (!complete) {
            start();
        }
    }

    private void retry() {
        String retry = inputView.retry();

        try {
            baseballService.validateRetryInput(retry);
        } catch (NumberFormatException e) {
            outputView.exception(e.getMessage());
            retry();
        }

        if (retry.equals("1")) {
            baseballService.resetAnswerNumber();
            start();
        }
    }
}
