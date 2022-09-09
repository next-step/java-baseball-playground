package study;

import baseball.BaseBallGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {
    @Test
    @DisplayName("세자리_번호_생성")
    void 세자리_번호_생성() {
        BaseBallGame baseBallGame = new BaseBallGame();

        assertThat(baseBallGame.createNumber(3).length())
            .isEqualTo(3);
        assertThat(baseBallGame.createNumber(2).length())
            .isNotEqualTo(3);
    }

    @Test
    @DisplayName("숫자가_맞으면_스트라이크가_된다")
    void 숫자가_맞으면_스트라이크가_된다() {
        BaseBallGame baseBallGame = new BaseBallGame();

        assertEquals(
            "3스트라이크",
            baseBallGame.gameResults("425", "425")
        );
    }

    @Test
    @DisplayName("숫자와_자리가_맞을경우")
    void 숫자와_자리가_맞을경우() {
        BaseBallGame baseBallGame = new BaseBallGame();

        assertAll(
            () -> assertEquals(
                "1스트라이크",
                baseBallGame.gameResults("425", "413")),
            () -> assertEquals(
                "2스트라이크",
                baseBallGame.gameResults("425", "415")),
            () -> assertEquals(
                "3스트라이크",
                baseBallGame.gameResults("425", "425"))
        );
    }

    @Test
    @DisplayName("숫자만_맞고_자리는_다를경우")
    void 숫자만_맞고_자리는_다를경우() {
        BaseBallGame baseBallGame = new BaseBallGame();

        assertEquals(
            "3볼",
            baseBallGame.gameResults("425", "542")
        );
        assertEquals(
            "2볼",
            baseBallGame.gameResults("425", "541")
        );
    }

    @Test
    @DisplayName("숫자_두개_맞고_자리는_하나만_맞을경우")
    void 숫자_두개_맞고_자리는_하나만_맞을경우() {
        BaseBallGame baseBallGame = new BaseBallGame();

        assertEquals("1볼1스트라이크", baseBallGame.gameResults("425", "482"));
    }

    @Test
    @DisplayName("숫자하_하나도_맞지_않을경우")
    void 숫자하_하나도_맞지_않을경우() {
        BaseBallGame baseBallGame = new BaseBallGame();

        assertEquals("낫싱", baseBallGame.gameResults("425", "789"));
    }

}
