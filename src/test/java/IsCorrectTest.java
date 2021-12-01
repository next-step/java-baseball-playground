import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IsCorrectTest {
    int playerBall = 123;
    int comBall = 123;

    GameConsole baseball = new GameConsole(playerBall, comBall);

    @Test
    @DisplayName("사용자가 숫자를 맞췄는 지 확인하는 테스트")
    void isCorrect() {
        baseball.play();
        assertThat(baseball.isCorrect()).isTrue();
    }
}
