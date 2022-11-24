package baseball;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {
    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void beforeEach() {
        randomNumberGenerator = new RandomNumberGeneratorImpl();
    }

    @DisplayName("랜덤 번호는 1부터 9까지의 범위 입니다.")
    @RepeatedTest(100)
    void 랜덤번호_범위() {
        List<Integer> list = randomNumberGenerator.generate();
        long count = list.stream().filter((v) -> v > 0 && v < 10).count();
        Assertions.assertThat(count).isEqualTo(3);
    }

}