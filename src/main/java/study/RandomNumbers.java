package study;

import java.util.HashSet;
import java.util.Random;

public class RandomNumbers {
    
    private final HashSet<Integer> randomNumbers = new HashSet<Integer>();
    
    public HashSet<Integer> answerNumbers() {
        Random random = new Random();
        while (randomNumbers.size() < 3) {
            randomNumbers.add(random.nextInt(9));
        }
        return randomNumbers;
    }

}
