import java.util.Random;

public class MovingCondition {
    private final Random random = new Random();
    private final OutputProcessor outputProcessor;

    public MovingCondition(OutputProcessor outputProcessor) {
        this.outputProcessor = outputProcessor;
    }

    public void moveTest(int[] cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars);
            outputProcessor.printCars(cars);
        }
    }

    private void moveCars(int[] cars) {
        for (int t = 0; t < cars.length; t++) {
            if (random.nextInt(10) >= 4) {
                cars[t]++;
            }
        }
    }
}