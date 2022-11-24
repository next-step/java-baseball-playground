package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.RandomListGenerator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {
    private Computer computer;

    @BeforeEach
    void beforeEach() {
        computer = new Computer(new RandomListGenerator() {
            @Override
            public List<Integer> generate() {
                return List.of(1, 2, 3);
            }
        });
    }

    @DisplayName("1스트라이크")
    @Test
    void OneStrike() {
        HintManager hintManager = new HintManager();
        hintManager.updateStrike();

        assertThat(computer.calculateHint(List.of(1, 4, 5)))
                .isEqualTo(hintManager);
    }

    @DisplayName("1스트라이크")
    @Test
    void TwoStrike() {
        HintManager hintManager = new HintManager();
        hintManager.updateStrike();
        hintManager.updateStrike();

        assertThat(computer.calculateHint(List.of(1, 2, 5)))
                .isEqualTo(hintManager);
    }

    @DisplayName("3스트라이크")
    @Test
    void ThreeStrike() {
        HintManager hintManager = new HintManager();
        hintManager.updateStrike();
        hintManager.updateStrike();
        hintManager.updateStrike();

        assertThat(computer.calculateHint(List.of(1, 2, 3)))
                .isEqualTo(hintManager);
    }

    @DisplayName("1볼")
    @Test
    void OneBall() {
        HintManager hintManager = new HintManager();
        hintManager.updateBall();

        assertThat(computer.calculateHint(List.of(3, 4, 5)))
                .isEqualTo(hintManager);
    }

    @DisplayName("2볼")
    @Test
    void TwoBall() {
        HintManager hintManager = new HintManager();
        hintManager.updateBall();
        hintManager.updateBall();

        assertThat(computer.calculateHint(List.of(2, 1, 5)))
                .isEqualTo(hintManager);
    }

    @DisplayName("3볼")
    @Test
    void ThreeBall() {
        HintManager hintManager = new HintManager();
        hintManager.updateStrike();
        hintManager.updateBall();
        hintManager.updateBall();

        assertThat(computer.calculateHint(List.of(3, 2, 1)))
                .isEqualTo(hintManager);
    }

    @DisplayName("1스트라이크 1볼")
    @Test
    void OneStrikeOneBall() {
        HintManager hintManager = new HintManager();
        hintManager.updateStrike();
        hintManager.updateBall();

        assertThat(computer.calculateHint(List.of(1, 4, 2)))
                .isEqualTo(hintManager);
    }

    @DisplayName("1스트라이크 2볼")
    @Test
    void OneStrikeTwoBall() {
        HintManager hintManager = new HintManager();
        hintManager.updateStrike();
        hintManager.updateBall();
        hintManager.updateBall();

        assertThat(computer.calculateHint(List.of(2, 1, 3)))
                .isEqualTo(hintManager);
    }

    @DisplayName("낫싱")
    @Test
    void nothing() {
        HintManager hintManager = new HintManager();

        assertThat(computer.calculateHint(List.of(4, 5, 6)))
                .isEqualTo(hintManager);
    }
}