package baesballgame.model.computer.domain.vo;

public class RandomNumber {

    private int randomNumber;

    public RandomNumber(final int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public static final RandomNumber of(final int randomNumber) {
        return new RandomNumber(randomNumber);
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
