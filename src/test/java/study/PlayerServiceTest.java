package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerServiceTest {

    PlayerService playerService;
    Player player;

    @BeforeEach
    void init() {
        playerService = new PlayerService();
        player = new Player();
    }

    @Test
    void 랜덤숫자_유효성_판단() {
        //given
        //when
        for (int i = 0; i < 100; i++) {
            player.makeComputersRandomBalls();
            //then
            assertThat(playerService.validate(player.ballList)).isTrue();
        }
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
