package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameStatusTest {

    @ParameterizedTest
    @CsvSource(value = {"PLAY,1", "OVER,2"})
    @DisplayName("게임의 상태를 반환한다")
    void status(GameStatus gameStatus, String status) {
        assertThat(gameStatus).isEqualTo(GameStatus.from(status));
    }

    @Test
    @DisplayName("올바르지 않은 게임 상태는 예외를 발생시킨다")
    void from_throw_exception_with_invalid_status() {
        String invalidStatus = "3";

        assertThatIllegalArgumentException().isThrownBy(() -> GameStatus.from(invalidStatus))
                .withMessage("잘못된 게임의 상태입니다");
    }
}
