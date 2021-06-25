package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerUtils {

    PlayerService playerService;
    Player player;

    @BeforeEach
    void init() {
        playerService = new PlayerService();
        player = playerService.makeNewPlayer();
        player.makeNewBalls(Arrays.asList(1, 2, 3));
    }

    @Test
    void 스트라이크_인지_판단한다() {
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
    void 볼_인지_판단한다() {
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
    void 낫싱_인지_판단한다() {
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

    @Test
    void 입력받은_숫자는_3자리수_여야한다() {
        assertThat(playerService.validate(Arrays.asList(1, 2, 3))).isTrue();
        assertThat(playerService.validate(Arrays.asList(1, 2, 3, 4))).isFalse();
        assertThat(playerService.validate(Arrays.asList(1, 2))).isFalse();
    }

    @Test
    void 입력받은_숫자는_3자리수_중복되면_안된다() {
        assertThat(playerService.validate(Arrays.asList(1, 2, 3))).isTrue();
        assertThat(playerService.validate(Arrays.asList(1, 1, 9))).isFalse();
        assertThat(playerService.validate(Arrays.asList(9, 9, 9))).isFalse();
    }

    @Test
    void 입력받은_숫자는_1_9_범위여야_된다() {
        //then
        assertThat(playerService.validate(Arrays.asList(1, 2, 3))).isTrue();
        assertThat(playerService.validate(Arrays.asList(1, 2, 10))).isFalse();
        assertThat(playerService.validate(Arrays.asList(0, 1, 2))).isFalse();
    }

}
