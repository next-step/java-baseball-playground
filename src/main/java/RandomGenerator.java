import java.util.LinkedHashSet;
import java.util.Random;

public class RandomGenerator {
    public LinkedHashSet<Integer> createRandomNums() {
        LinkedHashSet<Integer> randomNums = new LinkedHashSet<>();

        while (randomNums.size() < 3) {
            randomNums.add(getRandomNum());
        }

        return randomNums;
    }

    public int getRandomNum() {
        Random rd = new Random();
        return rd.nextInt(9) + 1;
    }


}
