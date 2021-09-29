package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerInputTest {

    @Test
    void 플레이어_숫자_3개_입력() {
        Player player = new Player("456");
        assertThat(Validation.confirmSize(player.getList())).isEqualTo(true);
    }
//
//    @Test
//    void 플레이어_중복_숫자_검증() {
//        Player player = new Player("556");
//        player.duplicationCheck(player.getList());
//    }
}
