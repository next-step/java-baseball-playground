import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StrikeBallTest {

    int playerBall = 123;
    int comBall = 156;

    GameConsole baseball = new GameConsole(playerBall, comBall);

    @Test
    @DisplayName("컴퓨터가 만든 세자리 수 안에 사용자 수 중 하나라도 있는지 판단 테스트")
    void isThereNum() {
        assertThat(baseball.isThereNum()).isTrue();
    }

    @Test
    @DisplayName("볼의 개수 파악")
    void countBall() {
        assertThat(baseball.ballCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("스타라이크 개수 파악")
    void countStrike() {
        assertThat(baseball.strikeCount()).isEqualTo(1);
    }

}
