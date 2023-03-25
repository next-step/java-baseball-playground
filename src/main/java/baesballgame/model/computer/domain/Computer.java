package baesballgame.model.computer.domain;

import baesballgame.model.computer.domain.vo.RandomNumber;
import java.util.Random;

public class Computer {

    private RandomNumber randomNumber;

    public void createRandomNumber() {
        final int number = new Random().ints(1, 10)
                .distinct()
                .limit(3)
                .reduce(0, (a, b) -> a * 10 + b);

        randomNumber = new RandomNumber(number);
    }

    public int getRandomNumber() {
        return randomNumber.getRandomNumber();
    }
}
