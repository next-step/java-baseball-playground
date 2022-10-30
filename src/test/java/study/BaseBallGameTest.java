package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallGameTest {


    @Test
    @DisplayName("숫자 야구 게임 - ball이 있는 경우")
    public void testCheckAnswer() {
        BaseBallGame baseBallGame = new BaseBallGame(new int[]{1, 2, 3});
        BaseBallGameResult result = baseBallGame.checkAnswer(new int[]{2, 1, 4});
        Assertions.assertThat(result.equals(new BaseBallGameResult(0, 2))).isTrue();
    }


    @Test
    @DisplayName("숫자 야구 게임 - 모두 strike인 경우")
    public void testCheckAnswer2() {
        BaseBallGame baseBallGame = new BaseBallGame(new int[]{1, 2, 3});
        BaseBallGameResult result = baseBallGame.checkAnswer(new int[]{1, 2, 3});
        Assertions.assertThat(result.equals(new BaseBallGameResult(3, 0))).isTrue();
    }

    @Test
    @DisplayName("숫자 야구 게임 - 모두 틀린 경우")
    public void testCheckAnswer3() {
        BaseBallGame baseBallGame = new BaseBallGame(new int[]{1, 2, 3});
        BaseBallGameResult result = baseBallGame.checkAnswer(new int[]{7, 8, 9});
        Assertions.assertThat(result.equals(new BaseBallGameResult(0, 0))).isTrue();
    }

    @Test
    @DisplayName("숫자 야구 게임 - 일부 맞은 경우")
    public void testCheckAnswer4() {
        BaseBallGame baseBallGame = new BaseBallGame(new int[]{1, 2, 3});
        BaseBallGameResult result = baseBallGame.checkAnswer(new int[]{8, 3, 3});
        Assertions.assertThat(result.equals(new BaseBallGameResult(1, 1))).isTrue();
    }

}