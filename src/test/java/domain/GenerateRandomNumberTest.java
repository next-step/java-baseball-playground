package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateRandomNumberTest {

    @Test
    @DisplayName("1~9 사이의 난수를 생성한다")
    void generate() {
        Generation generation = RandomNumberGeneration.from(new Random());

        int actual = generation.generate();

        assertThat(actual).isStrictlyBetween(0, 10);
    }
}
