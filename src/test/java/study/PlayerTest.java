package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    PlayerService playerService;
    Player player;

    @BeforeEach
    void init() {
        playerService = new PlayerService();
        player = playerService.makeNewPlayer();
        player.makeNewBalls(Arrays.asList(1, 2, 3));
    }

    @Test
    void 공_전체_결과판단() {
        //given
        //when
        //then
        assertThat(player.isThreeStrike(Arrays.asList(1, 2, 3))).isTrue();
        assertThat(player.isThreeStrike(Arrays.asList(2, 3, 5))).isFalse();
        assertThat(player.isThreeStrike(Arrays.asList(9, 8, 5))).isFalse();
    }

    @Test
    void 공하나_스트라이크_인지_판단한다() {
        //given
        int fistBall = 1;
        int secondBall = 2;
        int thirdBall = 3;
        //when
        //then
        assertThat(player.play(0, fistBall)).isEqualTo(Status.STRIKE);
        assertThat(player.play(1, secondBall)).isEqualTo(Status.STRIKE);
        assertThat(player.play(2, thirdBall)).isEqualTo(Status.STRIKE);
        assertThat(player.play(0, thirdBall)).isNotEqualTo(Status.STRIKE);
        assertThat(player.play(2, secondBall)).isNotEqualTo(Status.STRIKE);
    }

    @Test
    void 공하나_볼_인지_판단한다() {
        //given
        int fistBall = 1;
        int secondBall = 2;
        int thirdBall = 3;
        //when
        //then
        assertThat(player.play(1, fistBall)).isEqualTo(Status.BALL);
        assertThat(player.play(2, secondBall)).isEqualTo(Status.BALL);
        assertThat(player.play(0, thirdBall)).isEqualTo(Status.BALL);
        assertThat(player.play(0, fistBall)).isNotEqualTo(Status.BALL);
        assertThat(player.play(2, thirdBall)).isNotEqualTo(Status.BALL);
    }

    @Test
    void 공하나_낫싱_인지_판단한다() {
        //given
        int fistBall = 1;
        int secondBall = 5;
        int thirdBall = 6;
        //when
        //then
        assertThat(player.play(2, secondBall)).isEqualTo(Status.NOTHING);
        assertThat(player.play(0, thirdBall)).isEqualTo(Status.NOTHING);
        assertThat(player.play(0, fistBall)).isNotEqualTo(Status.NOTHING);
        assertThat(player.play(2, fistBall)).isNotEqualTo(Status.NOTHING);
    }

}
