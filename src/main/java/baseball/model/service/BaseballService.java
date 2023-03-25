package baseball.model.service;

import baseball.model.dto.BaseballGameResultDto;

public interface BaseballService {

    void validateInputValue(String input);

    BaseballGameResultDto getGameResult(String input);

    void resetAnswerNumber();

    void validateRetryInput(String input);
}
