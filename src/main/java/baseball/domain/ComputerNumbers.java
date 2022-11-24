package baseball.domain;

import baseball.RandomNumberGenerator;

public class ComputerNumbers extends Numbers {
    public ComputerNumbers(RandomNumberGenerator randomNumberGenerator) {
        super(randomNumberGenerator.generate());
    }
}
