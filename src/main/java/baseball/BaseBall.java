package baseball;

import java.util.Random;

public class BaseBall {
    private int[] value = new int[3];

    public BaseBall() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            value[i] = random.nextInt(9) + 1;
        }
    }
}