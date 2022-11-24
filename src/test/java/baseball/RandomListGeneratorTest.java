package baseball;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomListGeneratorTest {
    private RandomListGenerator randomListGenerator;

    @BeforeEach
    void beforeEach() {
        randomListGenerator = new RandomListGeneratorImpl();
    }

    @DisplayName("랜덤 번호는 1부터 9까지의 범위 입니다.")
    @RepeatedTest(100)
    void 랜덤번호_범위() {
        List<Integer> list = randomListGenerator.generate();
        long count = list.stream().filter((v) -> v > 0 && v < 10).count();
        Assertions.assertThat(count).isEqualTo(3);
    }

}