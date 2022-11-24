package baseball.domain;

import java.util.List;

public class UserNumbers extends Numbers {
    public UserNumbers(List<Integer> numbers) {
        super(numbers);
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateBoundary(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        final int EXACT_SIZE = 3;
        int numbersSize = numbers.size();
        if (numbersSize != EXACT_SIZE) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
    }

    private void validateBoundary(List<Integer> numbers) {
        final int EXACT_SIZE = 3;
        long dismissedSize = dismissDuplicateAndOutOfBoundNumber(numbers);
        if (dismissedSize != EXACT_SIZE) {
            throw new IllegalArgumentException("중복되지 않는 1부터 9까지의 숫자를 입력해주세요.");
        }
    }

    private static long dismissDuplicateAndOutOfBoundNumber(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .filter((each) -> each > 0 && each < 10)
                .count();
    }
}
