package baseball.model.validator;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class InputValidatorImpl implements InputValidator {

    private final String NATURAL_NUMBERS_MESSAGE = "각 자리는 자연수로만 이루어져야 합니다.";
    private final String DISTINCT_INPUT_MESSAGE = "서로 다른 수로 이루어져야 합니다.";
    private final String THREE_INPUT_MESSAGE = "3자리 수로 이루어져야 합니다.";
    private final String ONE_OR_TWO_MESSAGE = "입력은 1 또는 2만 가능합니다.";

    @Override
    public void validateNaturalNumbers(String input) {
        boolean result = Arrays.stream(splitInput(input))
                .mapToInt(this::inputToInteger)
                .allMatch(n -> n > 0);

        if (!result) {
            throw new IllegalArgumentException(NATURAL_NUMBERS_MESSAGE);
        }
    }

    private Integer inputToInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NATURAL_NUMBERS_MESSAGE);
        }
    }

    @Override
    public void validateDistinctInput(String input) {
        String[] splitInput = splitInput(input);

        Set<String> distinctValues = Arrays.stream(splitInput)
                .collect(Collectors.toSet());

        if (distinctValues.size() != splitInput.length) {
            throw new IllegalArgumentException(DISTINCT_INPUT_MESSAGE);
        }
    }

    @Override
    public void validateThreeInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(THREE_INPUT_MESSAGE);
        }
    }

    @Override
    public void validateOneOrTwo(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException(ONE_OR_TWO_MESSAGE);
        }
    }

    private String[] splitInput(String input) {
        return input.split("");
    }
}
