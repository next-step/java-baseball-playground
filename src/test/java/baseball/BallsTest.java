package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    private static final List<Integer> com = Arrays.asList(1, 2, 3);
    static final Balls balls = new Balls(com);
    @Test
    void 야구＿낫싱() {

        PlayResult result = balls.play(Arrays.asList(4,5,6));
        assertThat(result.getBallCount()).isEqualTo(0);
        assertThat(result.getStrikeCount()).isEqualTo(0);
    }

    @Test
    void 야구＿1볼() {

        PlayResult result = balls.play(Arrays.asList(2,4,5));
        assertThat(result.getBallCount()).isEqualTo(1);
    }
    @Test
    void 야구＿2볼() {

        PlayResult result = balls.play(Arrays.asList(2,3,5));
        assertThat(result.getBallCount()).isEqualTo(2);
    }
    @Test
    void 야구＿1볼_1스트라이크() {

        PlayResult result = balls.play(Arrays.asList(1,3,5));
        assertThat(result.getBallCount()).isEqualTo(1);
        assertThat(result.getStrikeCount()).isEqualTo(1);
    }
    @Test
    void 야구＿3스트라이크() {

        PlayResult result = balls.play(Arrays.asList(1,2,3));
        assertThat(result.getStrikeCount()).isEqualTo(3);
        assertThat(result.EndGame()).isEqualTo(true);
    }

}
