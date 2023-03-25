package baseball.model.service;

import baseball.model.dto.BaseballGameResultDto;
import baseball.model.entity.AnswerNumber;
import baseball.model.validator.InputValidator;

public class BaseballServiceImpl implements BaseballService {

    private final InputValidator inputValidator;

    private final AnswerNumber answerNumber;

    public BaseballServiceImpl(InputValidator inputValidator, AnswerNumber answerNumber) {
        this.inputValidator = inputValidator;
        this.answerNumber = answerNumber;
    }

    @Override
    public void validateInputValue(String input) {
        inputValidator.validateDistinctInput(input);
        inputValidator.validateThreeInput(input);
        inputValidator.validateNaturalNumbers(input);
    }

    @Override
    public BaseballGameResultDto getGameResult(String input) {
        Integer strikes = answerNumber.countStrikes(input);
        Integer balls = answerNumber.countBalls(input);
        Boolean nothing = answerNumber.isNothing(input);
        Boolean complete = answerNumber.isComplete(input);

        return new BaseballGameResultDto(strikes, balls, nothing, complete);
    }

    @Override
    public void resetAnswerNumber() {
        answerNumber.resetAnswerNumber();
    }

    @Override
    public void validateRetryInput(String input) {
        inputValidator.validateOneOrTwo(input);
    }
}
