package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
    void 입력받은_숫자는_3자리수_여야한다() {
        Assertions.assertThat(playerService.validateBallsSize(Arrays.asList(1, 2, 3))).isTrue();
        Assertions.assertThat(playerService.validateBallsSize(Arrays.asList(1, 2, 3, 4))).isFalse();
        Assertions.assertThat(playerService.validateBallsSize(Arrays.asList(1, 2))).isFalse();
    }

    @Test
    void 입력받은_숫자는_3자리수_중복되면_안된다() {
        Assertions.assertThat(playerService.validateDuplicate(Arrays.asList(1, 2, 3))).isTrue();
        Assertions.assertThat(playerService.validateDuplicate(Arrays.asList(1, 1, 9))).isFalse();
        Assertions.assertThat(playerService.validateDuplicate(Arrays.asList(9, 9, 9))).isFalse();
    }

    @Test
    void 입력받은_숫자는_1_9_범위여야_된다() {
        //then
        Assertions.assertThat(playerService.validateBallsRange(Arrays.asList(1, 2, 3))).isTrue();
        Assertions.assertThat(playerService.validateBallsRange(Arrays.asList(1, 2, 10))).isFalse();
        Assertions.assertThat(playerService.validateBallsRange(Arrays.asList(0, 1, 2))).isFalse();
    }

}
