package numberBaseballGame;

import java.util.*;

public class GenerateRandomNumber {

    public List<Integer> createRandomNumber() {
        Set<Integer> randomSet = new HashSet<>();
        String r = "";

        while (randomSet.size() < 3) {
            int d = (int) (Math.random() * 9 + 1);

            randomSet.add(d);
        }

        List<Integer> computerNumberList = new ArrayList<>(randomSet);

        return computerNumberList;
    }
}
