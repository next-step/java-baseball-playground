package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {
    public List<Integer> createRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = new Random().nextInt(9) + 1;
            if (numbers.contains(randomNumber)) {
                continue;
            }
            numbers.add(randomNumber);
        }
        return numbers;
    }

    public List<GameNumber> createGameNumbers(List<Integer> numbers) {
        List<GameNumber> gameNumbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            gameNumbers.add(new GameNumber(numbers.get(i)));
        }
        return gameNumbers;
    }
}
