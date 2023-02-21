package racing.core;

import java.util.Random;

public class CrazyDriver implements Driver {
    private static final int MOVE_BOUND = 10;
    private static final int MOVE_THRESHOLD = 4;
    private final Random random = new Random();

    @Override
    public boolean shouldMove() {
        return random.nextInt(MOVE_BOUND) > MOVE_THRESHOLD;
    }
}
