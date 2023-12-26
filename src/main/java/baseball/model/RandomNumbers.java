package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumbers {
    private final static int COMPUTER_NUMBER_SIZE = 3;
    private List<Integer> computerNumbers = new ArrayList<>();
    private Random random = new Random();

    public List<Integer> create() {
        while (computerNumbers.size() < COMPUTER_NUMBER_SIZE) {
            int number;
            number = random.nextInt(9);
            if (!computerNumbers.contains(number)) {
                computerNumbers.add(number);
            }
        }
        return computerNumbers;
    }

    public void deleteComputerNumbers() {
        computerNumbers.clear();
    }
}