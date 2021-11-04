package baseball.service;

import baseball.domain.Balls;
import org.junit.jupiter.api.Test;

public class RandomGeneratorTest {

    @Test
    void random() {
        RandomGenerator.getRandomBalls();
    }
}
