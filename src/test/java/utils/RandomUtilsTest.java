package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.RandomUtils.generateRandomNumber;

class RandomUtilsTest {

    @Test
    void generate() {
        int startInclusive = 1;
        int endInclusive = 9;

        int actual = generateRandomNumber(startInclusive, endInclusive);

        assertThat(actual).isBetween(startInclusive, endInclusive);
    }
}
