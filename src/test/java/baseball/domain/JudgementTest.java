package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgementTest {
    Judgement judgement = new Judgement();

    @Test
    @DisplayName("두 숫자배열에서 같은 숫자가 몇 개인지 확인")
    void findSameNumber() {
        assertThat(2).isEqualTo(judgement.findSameNumbers(Arrays.asList(1, 2, 3), Arrays.asList(5, 1, 2)));
    }

    @Test
    @DisplayName("스트라이크 개수 확인")
    void getStrikeCnt() {
        assertThat(2).isEqualTo(judgement.getStrikeCnt(Arrays.asList(1, 2, 5), Arrays.asList(1, 2, 3)));
    }
}
