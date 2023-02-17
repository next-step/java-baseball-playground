package study;

import numberBaseballGame.NumberBaseballGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberBaseballGameTest {

    NumberBaseballGame game = new NumberBaseballGame("123");

    @Test
    @DisplayName("정답확인")
    void isCorrectAnswer() {
        assertThat(game.isCorrectAnswer("123")).isEqualTo(true);
    }

    @Test
    void isRestart() {
        assertThat(game.isRestart("1")).isEqualTo(true);
    }
}