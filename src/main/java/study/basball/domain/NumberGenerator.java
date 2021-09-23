package study.basball.domain;

import java.util.HashSet;
import java.util.Random;

public class NumberGenerator {
    
    private final HashSet<Integer> randomNumbers = new HashSet<Integer>();
    
    public HashSet<Integer> createRandomNumbers() {
        Random random = new Random();
        while (randomNumbers.size() < 3) {
            int numbers = random.nextInt(9) + 1;
            randomNumbers.add(numbers);
        }
        return randomNumbers;
    }

}
