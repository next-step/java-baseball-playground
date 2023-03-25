package baseball.model.validator;

public interface InputValidator {

    void validateNaturalNumbers(String input);

    void validateDistinctInput(String input);

    void validateThreeInput(String input);

    void validateOneOrTwo(String input);
}
