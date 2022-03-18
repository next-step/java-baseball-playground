package CarRacingGame;

import java.util.Random;

public class FowardCondition {
    private int condition;

    public FowardCondition() {
        Random random = new Random();
        condition = random.nextInt(10);
    }

    public int getCondition() {
        return condition;
    }
}
