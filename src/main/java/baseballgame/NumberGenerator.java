package baseballgame;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NumberGenerator {

    public Set<Integer> createNumbers() {
        Set<Integer> computer = new HashSet<>();

        while (computer.size() < 3) {
            computer.add(new Random().nextInt(9) + 1);
        }
        return computer;
    }
}
