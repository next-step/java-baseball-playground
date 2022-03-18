package CarRacingGame;

public class CarNameParser {
    private String[] carNames;

    public CarNameParser(String carNames) {
        this.carNames = carNames.split(",");
    }

    public String[] getCarNames() {
        return carNames;
    }
}
