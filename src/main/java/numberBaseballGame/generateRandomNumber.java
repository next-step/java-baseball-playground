package numberBaseballGame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class generateRandomNumber {

    public List<Integer> createRandomNumber() {
        Set<Integer> randomSet = new HashSet();

        while(randomSet.size() < 3) {
            Double d = Math.random() * 10 + 1;
            randomSet.add(d.intValue());
        }

        List<Integer> randomNumList = new ArrayList<>(randomSet);

        return randomNumList;
    }
}
