package numberBaseballGame;

import java.util.HashSet;
import java.util.Set;

public class generateRandomNumber {

    public StringBuilder createRandomNumber() {
        Set<String> randomSet = new HashSet<>();
        String r = "";

        while (randomSet.size() < 3) {
            int d = (int) (Math.random() * 9 + 1);

            randomSet.add(String.valueOf(d));
        }
        StringBuilder sb = new StringBuilder();

        for (String idx : randomSet) {
            sb.append(idx);
        }

        return sb;
    }
}
