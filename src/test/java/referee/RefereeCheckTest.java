package referee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeCheckTest {

    @Test
    @DisplayName("스트라이크 볼 확인")
    void 스트라이크_볼_확인() {
        RefereeCheck refereeCheck = new RefereeCheck();
        assertThat(refereeCheck.strikeBallNumber(Arrays.asList(7, 1, 4), Arrays.asList(3, 1, 2)))
                .isEqualTo("1스트라이크 0볼");
    }
}
