package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {
    NumberGenerator numberGenerator = new NumberGenerator();

    @Test
    @DisplayName("컴퓨터가 생성한 난수가 3개의 숫자를 포함하였는지 확인")
    void createdThreeNumbers() {
        List<Integer> actual = numberGenerator.makeThreeNumbersByCom();
        assertThat(3).isEqualTo(actual.size());
    }
}
