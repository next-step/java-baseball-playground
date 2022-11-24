package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HintManagerTest {
    private HintManager hintManager;

    @BeforeEach
    void beforeEeach() {
        hintManager = new HintManager();
    }

    @DisplayName("힌트매니저는 Map의 값에 대해 equals와 hashCode가 오버라이드 되어있다.")
    @Test
    void equalsAndHashCode() {
        HintManager newManager = new HintManager();
        assertThat(hintManager).isEqualTo(newManager);
    }

    @DisplayName("스트라이크 증가")
    @Test
    void StrikeCount() {
        hintManager.updateStrike();
        assertThat(hintManager.getStrikeCount()).isEqualTo(1);
        hintManager.updateStrike();
        assertThat(hintManager.getStrikeCount()).isEqualTo(2);
        hintManager.updateStrike();
        assertThat(hintManager.getStrikeCount()).isEqualTo(3);
    }

    @DisplayName("볼 증가")
    @Test
    void BallCount() {
        hintManager.updateBall();
        assertThat(hintManager.getBallCount()).isEqualTo(1);
        hintManager.updateBall();
        assertThat(hintManager.getBallCount()).isEqualTo(2);
        hintManager.updateBall();
        assertThat(hintManager.getBallCount()).isEqualTo(3);
    }
}