package numberBaseballGame;

import java.util.*;

public class GenerateRandomNumber {
    private List<Integer> computerNumber;

    public GenerateRandomNumber() {
        List<Integer> randomNumber = this.createRandomNumber();
        this.computerNumber = new ArrayList<>(randomNumber);
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

    List<Integer> createRandomNumber() {
        Set<Integer> randomSet = new HashSet<>();

        while (randomSet.size() < 3) {
            int d = (int) (Math.random() * 9 + 1);

            randomSet.add(d);
        }

        List<Integer> computerList = new ArrayList<>(randomSet);

        return computerList;
    }
}
