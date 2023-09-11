package newBaseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputNumberSupplier implements NumberSupplier {
    private final String inputNumbers;

    public InputNumberSupplier(String inputNumbers) {
        if (!isValidNumber(inputNumbers)) {
            throw new IllegalArgumentException("1부터 9 사이의 중복되지 않는 숫자만 가능합니다.");
        }
        this.inputNumbers = inputNumbers;
    }

    private boolean isValidNumber(String inputNumbers) {
        boolean hasNotDuplicates = inputNumbers.length() == Arrays.stream(inputNumbers.split(""))
                .distinct()
                .count();
        boolean isValidRange = Arrays.stream(inputNumbers.split(""))
                .map(Integer::valueOf)
                .allMatch(number -> number >= 1 && number <= 9);
        return hasNotDuplicates && isValidRange;
    }

    @Override
    public List<Integer> getNumberList() {
        return Arrays.stream(inputNumbers.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
