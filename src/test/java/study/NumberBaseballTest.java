package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberBaseballTest {

    GameService gameService = new GameService();
    Game game;

    @BeforeEach
    void beforeGame() {
        game = gameService.makeGame();
    }

    @Test
    @DisplayName("랜덤한 숫자를 정한다.")
    void settingRandomValue() {
        //given
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //when
        gameService.setRandomNumber(game);
        int first = game.numbers[0];
        int second = game.numbers[1];
        int third = game.numbers[2];
        //then
        Assertions.assertThat(numbers).contains(first);
        Assertions.assertThat(numbers).contains(second);
        Assertions.assertThat(numbers).contains(third);
    }


    // - 랜덤한 숫자를 정한다.
    // - 사용자로 부터 숫자를 입력받는다.
    // - 랜덤한 숫자와 사용자의 숫자를 비교한다.
    // - 정답인지 아닌지 판단한다.
    // - 게임을 다시 시작한다.
}
