package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RandomGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RandomGeneratorTest {

    RandomGenerator randomGenerator = new RandomGenerator();

    @Test
    @DisplayName("중복이 없는 3자리 숫자를 리턴한다.")
    void createRandomNumbers() {
        List<Integer> actual = randomGenerator.createRandomNumbers();
        assertThat(actual.size()).isEqualTo(3);
    }
}
