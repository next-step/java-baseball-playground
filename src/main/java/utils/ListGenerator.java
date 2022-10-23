package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListGenerator {
    private final ValidationUtils validationUtils = new ValidationUtils();

    public List<Integer> mapToList(String userInput) {
        List<Integer> numbers = new ArrayList<>();

        for (char x : userInput.toCharArray()) {
            int element = x - '0';
            filterDuplicate(numbers, element);
        }

        return filterNumbers(numbers);
    }

    private List<Integer> filterNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(validationUtils::validateNumber)
                .collect(Collectors.toList());
    }

    private List<Integer> filterDuplicate(List<Integer> numbers, int element) {
        if (!numbers.contains(element))
            numbers.add(element);
        return numbers;
    }
}
