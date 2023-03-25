package baseball;

import baseball.controller.BaseballController;
import baseball.model.entity.AnswerNumberImpl;
import baseball.model.service.BaseballService;
import baseball.model.service.BaseballServiceImpl;
import baseball.model.validator.InputValidatorImpl;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballConfig {
    public static BaseballController set() {
        BaseballService baseballService = new BaseballServiceImpl(new InputValidatorImpl(), new AnswerNumberImpl());
        return new BaseballController(new InputView(), new OutputView(), baseballService);
    }
}
