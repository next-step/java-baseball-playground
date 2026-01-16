public class CarRacingMain {

    public static void main(String[] args) {
        InputProcessor inputProcessor = new InputProcessor();
        OutputProcessor outputProcessor = new OutputProcessor();

        int carCount = inputProcessor.inputCarCount();
        int tryCount = inputProcessor.inputTryCount();

        int[] cars = new int[carCount];

        MovingCondition movingCondition = new MovingCondition(outputProcessor);
        movingCondition.moveTest(cars, tryCount);
    }
}
