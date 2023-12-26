package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballNumbers {
    // TODO: 12/19/23
    // convertToBaseballNumber for문 스트림으로 해결
    // point 인티저 리스트를 베이스볼 리스트로 변경
    private List<BaseballNumber> numbers = new ArrayList<>();

    private final int BASEBALL_NUMBER_SIZE = 3;

    public BaseballNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        List<BaseballNumber> inputtedNumbers = convertToBaseballNumber(numbers);
        this.numbers = inputtedNumbers;
    }

    public List<BaseballNumber> convertToBaseballNumber(List<Integer> numbers) {
        List<BaseballNumber> inputtedNumbers = new ArrayList<>();

        for (int i = 0; i < BASEBALL_NUMBER_SIZE; i++) {
            int num = numbers.get(i);
            BaseballNumber baseballNumber = new BaseballNumber(num);
            inputtedNumbers.add(baseballNumber);
        }
        return inputtedNumbers;
    }

    private void validateDuplication(List<Integer> numbers) {
        List<Integer> list = numbers.stream().distinct().collect(Collectors.toList());
        if (numbers.size() != list.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != BASEBALL_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public List<BaseballNumber> getNumbers() {
        return numbers;
    }
}